package com.learn.demo.test;

import com.jcraft.jsch.ChannelSftp;
import com.learn.demo.sftp.SFTP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: TestAutoConfigurationSFTP
 * @Description: SftpClientConfigure测试类
 * @Author: 尚先生
 * @CreateDate: 2019/4/25
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAutoConfigurationSFTP {

    private static final Logger logger = LoggerFactory.getLogger(TestAutoConfigurationSFTP.class);

    @Autowired
    @Qualifier("coreSftpChannel")
    private ChannelSftp channelSftp;

    @Autowired
    private SFTP sftp;

    @Test
    public void testAotuDownload(){
        String trandate = "2019-04-25";
        boolean flag = false;
        sftp.setChannelSftp(channelSftp);
        flag = sftp.downloadOKFile(trandate);
        flag = sftp.downloadCoreFilesToLocal(trandate);
        logger.error("下载文件结果：[{}]",new Object[]{flag});
    }

}
