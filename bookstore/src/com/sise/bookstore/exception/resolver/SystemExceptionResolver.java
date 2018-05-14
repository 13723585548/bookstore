/**   
* @Project:	springmvc_mybatis
* @Title: SystemExceptionResolver.java
* @Package com.sise.ssm.exception.resolver
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月19日 下午11:17:13
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.exception.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.sise.bookstore.exception.VerifyCodeException;


/**
 * @ClassName: SystemExceptionResolver
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月19日 下午11:17:13
 * 
 */

public class SystemExceptionResolver implements HandlerExceptionResolver {

    /* (非 Javadoc) 
     * <p>Title: resolveException</p> 
     * <p>Description: </p> 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return 
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception) 
     */

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
        String message = null;
        if (ex instanceof UnknownAccountException) {
            message = ex.getMessage();
        } else if (ex instanceof IncorrectCredentialsException) {
            message = ex.getMessage();
        } else if (ex instanceof UnauthorizedException) {
            message = "你没有该权限";
        } else if (ex instanceof VerifyCodeException){
            message = ex.getMessage();
        } else if(ex instanceof Exception){
            message = ex.getMessage();
        } else {
            message = "未知错误";
        }
         
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", message);
        mv.setViewName("error");
        
        return mv;
    }

}
