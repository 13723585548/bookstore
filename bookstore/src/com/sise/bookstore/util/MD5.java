/**   
* @Project:	bookstore
* @Title: MD5.java
* @Package com.sise.bookstore.util
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月25日 下午8:04:48
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;


/**
 * @ClassName: MD5
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年10月25日 下午8:04:48
 * 
 */

public class MD5 {
    
    public static String getMd5(String originalPassword, String salt) throws IOException {
        
        //加载配置文件,读取散列次数、算法
        Properties prop = new Properties();
        prop.load(MD5Test.class.getClassLoader().getResourceAsStream("md5.properties")); 
        String iterations = prop.getProperty("iterations");
        String algorithm = prop.getProperty("algorithm");
        
        Md5Hash md5Hash = new Md5Hash(originalPassword, salt, Integer.parseInt(iterations));
        
        String md5Password = md5Hash.toString();
        
        System.out.println(md5Password);
        
        SimpleHash simpleHash = new SimpleHash(algorithm, originalPassword, salt, Integer.parseInt(iterations));
        
        return simpleHash.toString();
    }
    
    public static void main(String[] args) throws IOException {
    	System.out.println(getMd5("admin", "qwerty"));
	}
    
}
