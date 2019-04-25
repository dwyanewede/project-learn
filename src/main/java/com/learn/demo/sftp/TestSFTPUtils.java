package com.learn.demo.sftp;

import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ClassName: TestSFTPUtils
 * @Description: SFTP工具类测试类
 * @Author: 尚先生
 * @CreateDate: 2019/4/25 11:09
 * @Version: 1.0
 */
public class TestSFTPUtils {

    private static final Logger logger = LoggerFactory.getLogger(TestSFTPUtils.class);

    public static void main(String[] args) {
            SFTP ftp = new SFTP(3, 6000);
            SftpConfig sftpConfig = new SftpConfig("10.0.155.55", 22, "pucms", "pucms", 1000, "/opt/bdepfile/bdp/pucms/20190108");
            try {
                List<String> list = ftp.listFiles("/opt/bdepfile/bdp/pucms/20190108", sftpConfig);
                logger.info("文件上传下载详情"  ,new Object[]{list});
            } catch (SftpException e) {
                logger.error("文件上传下载异常:[{}]" ,new Object[]{e});
            }
        }
}
