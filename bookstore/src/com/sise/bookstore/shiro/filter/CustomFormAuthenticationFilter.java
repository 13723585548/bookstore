/**   
* @Project:	shiro
* @Title: CustomFormAuthenticationFilter.java
* @Package com.sise.bookstore.shiro.filter;
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月9日 上午8:03:55
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;


/**
 * @ClassName: CustomFormAuthenticationFilter
 * @Description: 表单认证过滤器
 * @author: zhiguo.lin
 * @date 2016年10月9日 上午8:03:55
 * 
 */

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    
    
    /* (非 Javadoc) 
    * <p>Title: onAccessDenied</p> 
    * <p>Description: </p> 
    * @param request
    * @param response
    * @return
    * @throws Exception 
    * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#onAccessDenied(javax.servlet.ServletRequest, javax.servlet.ServletResponse) 
    */ 
    @Override   
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
  
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        
        String userCode = httpServletRequest.getParameter("userCode");
        if(StringUtils.isBlank(userCode) || userCode.length() < 3 || userCode.length() >18) {
            httpServletRequest.setAttribute("shiroLoginFailure", "userCodeError");
            return true;
        }
        
        String password = httpServletRequest.getParameter("password");
        if (StringUtils.isBlank(password) || password.length() < 6 || password.length() > 15) {
            httpServletRequest.setAttribute("shiroLoginFailure", "passwordError");
            return true;
        }
        
        HttpSession session = httpServletRequest.getSession();
        //取出验证码
        String verifyCode = (String) session.getAttribute("verifyCode");
        String randomCode = httpServletRequest.getParameter("randomCode");
        
        if(verifyCode != null && randomCode != null && !verifyCode.equals(randomCode)) {
            httpServletRequest.setAttribute("shiroLoginFailure", "verifyCodeError");
            return true;
        }
        return super.onAccessDenied(request, response);
    }

}
