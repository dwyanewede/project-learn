package com.learn.demo.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ClassName: RandomAccessFileDemo
 * @Description: RandomAccessFile 文件读写处理
 * @Author: 尚先生
 * @CreateDate: 2019/6/20 14:07
 * @Version: 1.0
 */
public class RandomAccessFileDemo {


    public static void main(String[] args) throws Exception {

        // 定位文件信息
        String prixPath = System.getProperty("user.dir");

        String suffixPath = "\\src\\main\\java\\com\\learn\\demo\\file\\testAccessFile.properties";

        // 创建随机读写文件
        RandomAccessFile accessFile = new RandomAccessFile(prixPath.concat(suffixPath),"rwd");

        // 读取文件
        readRandomAccessFile(accessFile);

        // 写入文件
        writeRandomAccessFile(accessFile);

        //操作结束后一定要关闭文件
        accessFile.close();
    }


    private static void writeRandomAccessFile(RandomAccessFile accessFile) throws IOException {
        synchronized (RandomAccessFileDemo.class) {
            for (int i = 1; i < 10; i++) {
                StringBuilder writeBuffer = new StringBuilder();
                writeBuffer.append("\r\n");
                writeBuffer.append("i love you " + i);
                accessFile.write(writeBuffer.toString().getBytes());
            }

        }
        //操作结束后一定要关闭文件
//        accessFile.close();

    }

    private static void readRandomAccessFile(RandomAccessFile accessFile) throws Exception {

        //读取文件，在读取前需要通过seek()方法把文件指针移到最前
        accessFile.seek(0);

        // 递归输出文件读取结果
        String readLine = accessFile.readLine();

        do {
            System.out.println("读文件输出结果： " + readLine);
            readLine = accessFile.readLine();
        }while (null != readLine);

        //操作结束后一定要关闭文件
//        accessFile.close();
    }
}
