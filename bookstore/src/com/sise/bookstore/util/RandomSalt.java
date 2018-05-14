/**   
* @Project:	bookstore
* @Title: RandomSalt.java
* @Package com.sise.bookstore.util
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月25日 下午7:38:59
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.util;

import java.util.Random;


/**
 * @ClassName: RandomSalt
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年10月25日 下午7:38:59
 * 
 */

public class RandomSalt {

    //生成随机数字和字母,  
    public static String getStringRandom(int length) {  
          
        String salt = "";  
        Random random = new Random();  
          
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
              
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                salt += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                salt += String.valueOf(random.nextInt(10));  
            }  
        }  
        return salt;  
    }
}
