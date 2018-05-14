/**   
* @Project:	springmvc_mybatis
* @Title: ParameterException.java
* @Package com.sise.ssm.exception
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月15日 下午11:32:39
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.exception;


/**
 * @ClassName: ParameterException
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月15日 下午11:32:39
 * 
 */

public class ParameterException extends RuntimeException {
    
    /**
    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
    */
    
    private static final long serialVersionUID = 5903972518798057635L;
    
    private String message;
    
    public ParameterException(String message) {
        super(message);
        this.message = message;
    }

    
    public String getMessage() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }

}
