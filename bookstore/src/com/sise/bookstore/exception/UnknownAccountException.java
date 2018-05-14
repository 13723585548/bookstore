/**   
* @Project:	permission
* @Title: UnknownAccountException.java
* @Package com.sise.ssm.exception
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月29日 下午12:39:22
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.exception;


/**
 * @ClassName: UnknownAccountException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月29日 下午12:39:22
 * 
 */

public class UnknownAccountException extends RuntimeException {
    
    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 9101733399342498044L;
   
     private String message;
     
     public UnknownAccountException (String message) {
         super (message);
         this.message = message;
     }

     
     public String getMessage() {
         return message;
     }

     
     public void setMessage(String message) {
         this.message = message;
     }

}
