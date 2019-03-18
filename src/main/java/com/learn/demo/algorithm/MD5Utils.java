package com.learn.demo.algorithm;
 
import java.security.MessageDigest;
import java.security.SecureRandom;
 
/**
 * Created by yanshao on 2018/12/17.
 */
public class MD5Utils {
 
    //盐值长度
    private static final int SALT_LENGTH = 30;
    //加密算法
    private static final String  ALGORITHM = "MD5";
    //编码
    private static final String CHARSET = "UTF-8";
    //密码加密长度
    private static final int MD5_LENGTH = 32;
 
    /**
     * byte数组转换成十六进制字符串
     * @param bytes byte数组
     * @return
     */
    private static String bytesToHexStr(byte[] bytes) {
        String tmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < bytes.length; i++) {
            tmp = Integer.toHexString(bytes[i] & 0xFF);
            sb.append((tmp.length() == 1) ? "0" + tmp : tmp);
        }
        return sb.toString().toUpperCase().trim();
    }
 
    /**
     * 十六进制字符串转成byte数组
     * @param hexStr   十六进制字符串
     * @return
     * */
    private static byte[] hexStrToBytes(String hexStr) {
        byte[] bytes = new byte[hexStr.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hexStr.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
 
    /**
     * 生成随机盐
     * @return 返回长度为SALT_LENGTH * 2的盐
     * */
    public static String createSaltValue(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return bytesToHexStr(salt);
    }
 
    /**
     * 用户密码使用md5加密
     * @param password  用户密码
     * @return          返回长度为32位的16进制字符串
     * */
    public static String md5EncodePwd(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] result = digest.digest(password.getBytes(CHARSET));
            return bytesToHexStr(result);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
 
    /**
     * 按照salt+pwd的顺序返回最终要保存到数据库的密码
     * @param salt           随机盐
     * @param md5encodePwd  经过md5加密的字符串
     * @return               按照规则返回的最终密码
     * */
    public static String getFinalPwd(String salt,String md5encodePwd){
        StringBuilder stringBuilder = new StringBuilder();
        /**
         * 前64位规则：
         * 奇数位是用户真实密码的hash值
         * 偶数为是盐值
         * 后16位:是剩余的盐值
         * */
        // TODO: 2018/12/17 根据实际需求定义规则 
        for(int i=0 ; i<md5encodePwd.length(); i++){
            stringBuilder.append(md5encodePwd.substring(i,i+1))
                    .append(salt.substring(i,i+1));
        }
        stringBuilder.append(salt.substring(md5encodePwd.length(),salt.length()));
        return stringBuilder.toString();
    }
 
    /**
     * 按照salt+pwd的顺序返回最终要保存到数据库的密码
     * @return    按照规则返回的最终密码
     * */
    public static String createHashPwd(String password){
        return getFinalPwd(createSaltValue(),md5EncodePwd(password));
    }
 
    /**
     * 从数据库中保存的最终密码，解析出用户真实秘密的md5加密串
     * @return    返回真实秘密的加密串
     * */
    public static String getUserPwdMD5(String finalPwd){
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0 ; i < MD5_LENGTH * 2 ; i+=2){
                stringBuilder.append(finalPwd.substring(i,i+1));
            }
            return stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
 
    /**
     * 验证用户输入的密码是否正确
     * @param password  用户输入的密码
     * @param finalPwd  数据库中保存的密码
     * @return           验证结果：true密码正确，反之密码错误
     * */
    public static boolean verifyPwd(String password,String finalPwd){
        return password == null ?
                false : md5EncodePwd(password).equals(getUserPwdMD5(finalPwd));
    }
 
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for( int i=0;i<100;i++){
            /**
             * 生成加密密码
             * */
            String userPwd = "sxs@wy"+i;
            String salt = createSaltValue();
            System.out.println("盐值>>"+salt);
            String md5encodePwd = md5EncodePwd(userPwd);
            System.out.println("md5>>"+md5encodePwd);
            String finalPwd = getFinalPwd(salt,md5encodePwd);
            if(sb.toString().contains(finalPwd)){
                System.out.println("重复的密码>>"+finalPwd);
                break;
            }
            sb.append(finalPwd);
            System.out.println("最终密码>>"+finalPwd);
            /**
             * 用户登录输入密码，验证秘密是否正确
             * */
            boolean verify = verifyPwd(userPwd,finalPwd);
            System.out.println("密码正确");
            if (verify == false){
                System.out.println("输入的密码>>"+userPwd+">>密码验证失败>>"+getUserPwdMD5(finalPwd));
                break;
            }
        }
    }
 
}
