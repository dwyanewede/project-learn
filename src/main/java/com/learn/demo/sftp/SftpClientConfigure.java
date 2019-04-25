package com.learn.demo.sftp;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Properties;

/**
 * @ClassName: SftpClientConfigure
 * @Description: 自动装配Sftp连接器
 * @Author: 尚先生
 * @CreateDate: 2019/4/25
 * @Version: 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "sftp")
public class SftpClientConfigure {

    private String hostname;
    private Integer port;
    private String username;
    private String password;
    private Integer timeout;
    private String privateKey;
    private String remoteRootPath;
    private String fileSuffix;

    // 通道类型
    private static final String CHANNEL_TYPE = "sftp";

    private static final Logger logger = LoggerFactory.getLogger(SftpClientConfigure.class);

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getRemoteRootPath() {
        return remoteRootPath;
    }

    public void setRemoteRootPath(String remoteRootPath) {
        this.remoteRootPath = remoteRootPath;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Bean("sshSession")
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Session session() throws JSchException {
        if (logger.isInfoEnabled()) {
            logger.info("获取session，设置的超时时间为[{}]毫秒", timeout);
        }
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        // 设置秘钥
//        jsch.addIdentity(privateKey);
        session.setPassword(password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);  //为Session对象设置properties
        session.setTimeout(timeout);  //设置timeout时间
        session.connect();  //通过Session建立链接
        return session;
    }

    @Bean("coreSftpChannel")
    @Lazy
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ChannelSftp channel(Session session) throws JSchException {
        if (logger.isInfoEnabled()) {
            logger.info("初始化sftp连接");
        }
        Channel channel = session.openChannel(CHANNEL_TYPE);  //打开SFTP通道
        channel.connect();  //建立SFTP通道的连接
        return (ChannelSftp) channel;
    }

}