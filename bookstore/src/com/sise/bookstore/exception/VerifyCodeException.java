/**   
* @Project:	shiro
* @Title: ValidateCodeException.java
* @Package com.sise.ssm.exception
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月9日 上午8:15:53
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.exception;


/**
 * @ClassName: ValidateCodeException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年10月9日 上午8:15:53
 * 
 */

public class VerifyCodeException extends RuntimeException {

    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    
    private static final long serialVersionUID = 2971650005302284620L;
    
    private String message;
    
    public VerifyCodeException (String message) {
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
