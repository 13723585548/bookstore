/**   
* @Project:	bookstore
* @Title: AdminLoginFilter.java
* @Package com.sise.bookstore.controller.admin.filter
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月22日 下午6:08:08
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName: AdminLoginFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月22日 下午6:08:08
 * 
 */

public class AdminLoginFilter implements Filter  {

    /* (非 Javadoc) 
    * <p>Title: destroy</p> 
    * <p>Description: </p>  
    * @see javax.servlet.Filter#destroy() 
    */ 
    
    
    @Override
    public void destroy() {
    }

    /* (非 Javadoc) 
    * <p>Title: doFilter</p> 
    * <p>Description: </p> 
    * @param arg0
    * @param arg1
    * @param arg2
    * @throws IOException
    * @throws ServletException 
    * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain) 
    */ 
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        
        /*
         * 1. 获取session中的user
         * 2. 判断是否为null
         *   > 如果为null：保存错误信息，转发到msg.jsp
         *   > 如果不为null：放行
         */
        HttpServletRequest req = (HttpServletRequest) request;
        Object user = req.getSession().getAttribute("admin");
        if(user == null) {
            req.setAttribute("code", "error");//为了显示X图片
            req.setAttribute("msg", "您还没有登录，不能访问本资源");
            req.getRequestDispatcher("/jsp/backstage/login.jsp").forward(req, response);
        } else {
            chain.doFilter(request, response);//放行
        }
        
    }

    /* (非 Javadoc) 
    * <p>Title: init</p> 
    * <p>Description: </p> 
    * @param arg0
    * @throws ServletException 
    * @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 
    */ 
    
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
