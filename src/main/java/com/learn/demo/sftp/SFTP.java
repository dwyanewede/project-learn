package com.learn.demo.sftp;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * @ClassName: SFTP
 * @Description: sftp上传通用类
 * @Author: 尚先生
 * @CreateDate: 2019/1/3
 * @Version: 1.0
 */
@Component
public class SFTP {

    private long count;
    /**
     * 已经连接次数
     */
    private long count1 = 0;

    private long sleepTime;

    private ChannelSftp channelSftp;

    @Value("${sftp.remotepath}")
    private String remotepath;

    @Value("${sftp.localpath}")
    private String localpath;

    @Value("${sftp.filenames}")
    private String filenames;

    private static final String COMPLATEG_FILE_FLAG = "over_%s.dat";

    private static final Logger logger = LoggerFactory.getLogger(SFTP.class);

    /**
     * 连接sftp服务器
     *
     * @return
     */
    public ChannelSftp connect(SftpConfig sftpConfig) {
        ChannelSftp sftp = null;
        try {
            JSch jsch = new JSch();
            jsch.getSession(sftpConfig.getUsername(), sftpConfig.getHostname(), sftpConfig.getPort());
            Session sshSession = jsch.getSession(sftpConfig.getUsername(), sftpConfig.getHostname(), sftpConfig.getPort());
            logger.info("Session created ... UserName=" + sftpConfig.getUsername() + ";host=" + sftpConfig.getHostname() + ";port=" + sftpConfig.getPort());
            sshSession.setPassword(sftpConfig.getPassword());
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            logger.info("Session connected ...");
            logger.info("Opening Channel ...");
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            logger.info("登录成功");
        } catch (Exception e) {
            try {
                count1 += 1;
                if (count == count1) {
                    throw new RuntimeException(e);
                }
                Thread.sleep(sleepTime);
                logger.info("重新连接....");
                connect(sftpConfig);
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1);
            }
        }
        return sftp;
    }

    /**
     * 上传文件
     *
     * @param directory  上传的目录
     * @param uploadFile 要上传的文件
     * @param sftpConfig
     */
    public void upload(String directory, String uploadFile, SftpConfig sftpConfig) {
        ChannelSftp sftp = connect(sftpConfig);
        try {
            sftp.cd(directory);
        } catch (SftpException e) {
            try {
                sftp.mkdir(directory);
                sftp.cd(directory);
            } catch (SftpException e1) {
                throw new RuntimeException("ftp创建文件路径失败" + directory);
            }
        }
        File file = new File(uploadFile);
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(file);
            sftp.put(inputStream, file.getName());
        } catch (Exception e) {
            throw new RuntimeException("sftp异常" + e);
        } finally {
            disConnect(sftp);
            closeStream(inputStream,null);
        }
    }

    /**
     * 下载文件
     *
     * @param directory    下载目录
     * @param downloadFile 下载的文件
     * @param saveFile     存在本地的路径
     * @param sftpConfig
     */
    public void download(String directory, String downloadFile, String saveFile, SftpConfig sftpConfig) {
        OutputStream output = null;
        try {
            File localDirFile = new File(saveFile);
            // 判断本地目录是否存在，不存在需要新建各级目录
            if (!localDirFile.exists()) {
                localDirFile.mkdirs();
            }
            if (logger.isInfoEnabled()) {
                logger.info("开始获取远程文件:[{}]---->[{}]", new Object[]{directory, saveFile});
            }
            ChannelSftp sftp = connect(sftpConfig);
            sftp.cd(directory);
            if (logger.isInfoEnabled()) {
                logger.info("打开远程文件:[{}]", new Object[]{directory});
            }
            output = new FileOutputStream(new File(saveFile.concat(File.separator).concat(downloadFile)));
            sftp.get(downloadFile, output);
            if (logger.isInfoEnabled()) {
                logger.info("文件下载成功");
            }
            disConnect(sftp);
        } catch (Exception e) {
            if (logger.isInfoEnabled()) {
                logger.info("文件下载出现异常，[{}]", e);
            }
            throw new RuntimeException("文件下载出现异常，[{}]", e);
        } finally {
            closeStream(null,output);
        }
    }

    /**
     * 下载远程文件夹下的所有文件
     *
     * @param remoteFilePath
     * @param localDirPath
     * @throws Exception
     */
    public void getFileDir(String remoteFilePath, String localDirPath, SftpConfig sftpConfig) throws Exception {
        File localDirFile = new File(localDirPath);
        // 判断本地目录是否存在，不存在需要新建各级目录
        if (!localDirFile.exists()) {
            localDirFile.mkdirs();
        }
        if (logger.isInfoEnabled()) {
            logger.info("sftp文件服务器文件夹[{}],下载到本地目录[{}]", new Object[]{remoteFilePath, localDirFile});
        }
        ChannelSftp channelSftp = connect(sftpConfig);
        Vector<LsEntry> lsEntries = channelSftp.ls(remoteFilePath);
        if (logger.isInfoEnabled()) {
            logger.info("远程目录下的文件为[{}]", lsEntries);
        }
        for (LsEntry entry : lsEntries) {
            String fileName = entry.getFilename();
            if (checkFileName(fileName)) {
                continue;
            }
            String remoteFileName = getRemoteFilePath(remoteFilePath, fileName);
            channelSftp.get(remoteFileName, localDirPath);
        }
        disConnect(channelSftp);
    }

    /**
     * 关闭流
     * @param outputStream
     */
    private void closeStream(InputStream inputStream,OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkFileName(String fileName) {
        if (".".equals(fileName) || "..".equals(fileName)) {
            return true;
        }
        return false;
    }

    private String getRemoteFilePath(String remoteFilePath, String fileName) {
        if (remoteFilePath.endsWith("/")) {
            return remoteFilePath.concat(fileName);
        } else {
            return remoteFilePath.concat("/").concat(fileName);
        }
    }

    /**
     * 删除文件
     *
     * @param directory  要删除文件所在目录
     * @param deleteFile 要删除的文件
     * @param sftp
     */
    public void delete(String directory, String deleteFile, ChannelSftp sftp) {
        try {
            sftp.cd(directory);
            sftp.rm(deleteFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 列出目录下的文件
     *
     * @param directory  要列出的目录
     * @param sftpConfig
     * @return
     * @throws SftpException
     */
    public List<String> listFiles(String directory, SftpConfig sftpConfig) throws SftpException {
        ChannelSftp sftp = connect(sftpConfig);
        List fileNameList = new ArrayList();
        try {
            sftp.cd(directory);
        } catch (SftpException e) {
            return fileNameList;
        }
        Vector vector = sftp.ls(directory);
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) instanceof LsEntry) {
                LsEntry lsEntry = (LsEntry) vector.get(i);
                String fileName = lsEntry.getFilename();
                if (".".equals(fileName) || "..".equals(fileName)) {
                    continue;
                }
                fileNameList.add(fileName);
            }
        }
        disConnect(sftp);
        return fileNameList;
    }

    /**
     * 断掉连接
     */
    public void disConnect(ChannelSftp sftp) {
        try {
            sftp.disconnect();
            sftp.getSession().disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SFTP(long count, long sleepTime) {
        this.count = count;
        this.sleepTime = sleepTime;
    }

    public SFTP() {

    }

    public void setChannelSftp(ChannelSftp channelSftp) {
        this.channelSftp = channelSftp;
    }

    /**
     *
     * @param remotePath
     * @param remoteFileName
     * @param localPath
     * @param localFileName
     * @return
     */
    public boolean downloadFile(String remotePath, String remoteFileName, String localPath, String localFileName){
        logger.info("开始下载文件，远程路径:[{}],本地路径:[{}],文件名称:[{}]",new Object[]{remotePath,localPath,remoteFileName});
        FileOutputStream fileOutputStream = null;
        File file = new File(localPath + localFileName);
        try {
            fileOutputStream = new FileOutputStream(file);
            channelSftp.get(remotePath + remoteFileName,fileOutputStream);
            return true;
        } catch (Exception e) {
            logger.error("sftp下载文件失败:[{}]",new Object[]{e});
            return false;
        }
    }

    /**
     * 单个ok文件下载
     * @param trandate
     * @return
     */
    public boolean downloadOKFile(String trandate){
        trandate = trandate.replace("-", "");
        String localDirPath = localpath.concat("/").concat(trandate);
        File localDirFile = new File(localDirPath);
        if (!localDirFile.exists()){
            localDirFile.mkdirs();
        }else {
            logger.info("文件[{}]已存在",new Object[]{localDirPath});
            if (!localDirFile.isDirectory()){
                logger.error("文件[{}]已存在，但不是目录，文件下载失败",new Object[]{localDirPath});
                throw new RuntimeException(String.format("本地文件[{%s}]已存在，但不是目录，不能创建文件",localDirPath));
            }
        }
        String filename = String.format(COMPLATEG_FILE_FLAG, trandate);
        String remoteFilePath = remotepath.concat("/").concat(trandate).concat("/");
        String localFilePath = localDirPath.concat("/");
        boolean flag = downloadFile(remoteFilePath, filename, localFilePath, filename);
        return flag;
    }

    /**
     * 多个文件下载
     * @param trandate
     * @return
     */
    public boolean downloadCoreFilesToLocal(String trandate){
        boolean flag = false;
        trandate = trandate.replace("-", "");
        String localDirPath = localpath.concat("/").concat(trandate).concat("/");
        String remoteDirPath = remotepath.concat("/").concat(trandate).concat("/");
        for (String coreFileName : filenames.split(",")){
            //文件名称截取
            String coreFilaName = String.format(coreFileName.trim(), trandate);
            flag = downloadFile(remoteDirPath, coreFileName, localDirPath, coreFileName);
        }
        return flag;
    }

}