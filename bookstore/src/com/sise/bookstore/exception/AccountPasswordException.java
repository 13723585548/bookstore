/**   
* @Project:	permission
* @Title: AccountPasswordException.java
* @Package com.sise.ssm.exception
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月29日 下午1:19:06
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.exception;


/**
 * @ClassName: AccountPasswordException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月29日 下午1:19:06
 * 
 */

public class AccountPasswordException extends RuntimeException {

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    
    private static final long serialVersionUID = -771602767161713167L;
    
    private String message;
    
    public AccountPasswordException (String message) {
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
