/**   
* @Project:	bookstore
* @Title: MD5.java
* @Package com.sise.bookstore.util
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年12月2日 下午1:37:31
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: MD5
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年12月2日 下午1:37:31
 * 
 */

public class MD5Test {
    
    public static void main(String[] args) throws Exception {
        //原始密码
        String originalPassword = "admin";
        //盐
        String salt = "qwerty";
        //散列次数
        int hashIterations = 2;
        
        Md5Hash md5Hash = new Md5Hash(originalPassword, salt, hashIterations);
        
        String md5Password = md5Hash.toString();
        
        System.out.println(md5Password);
        System.out.println(CommonUtils.uuid());
        
        SimpleHash simpleHash = new SimpleHash("md5", originalPassword, salt, hashIterations);
        
        System.out.println(simpleHash.toString());
    }

}
