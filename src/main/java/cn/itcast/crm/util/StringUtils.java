package cn.itcast.crm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

public class StringUtils {
    //MD5加密
    public static String getMD5Value(String value) {
        try {
            //1 获得消息摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2 加密 -- 获得10进制
            byte[] md5ValueByteArr = messageDigest.digest(value.getBytes());
            //3 将10机制 转换 16进制
            BigInteger bigInteger = new BigInteger(1, md5ValueByteArr);
            return bigInteger.toString(16);
        } catch (Exception e) {
            return value;
        }
    }

    //获得32长度UUID值
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
