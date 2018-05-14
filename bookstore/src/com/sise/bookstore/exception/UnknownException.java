/**   
* @Project:	shiro
* @Title: UnknownException.java
* @Package com.sise.ssm.exception
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月6日 下午4:47:23
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.exception;


/**
 * @ClassName: UnknownException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年10月6日 下午4:47:23
 * 
 */

public class UnknownException extends RuntimeException {

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    
    private static final long serialVersionUID = -6463474929194843504L;
    
    private String message;
    
    public UnknownException(String message) {
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
