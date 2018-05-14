/**   
* @Project:	permission
* @Title: LoginInterceptor.java
* @Package com.sise.ssm.interceptor
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月29日 下午6:32:43
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sise.bookstore.model.pojo.ActiveUser;
import com.sise.bookstore.util.ResourcesUtil;


/**
 * @ClassName: LoginInterceptor
 * @Description: 用户身份认证拦截器
 * @author: zhiguo.lin
 * @date 2016年9月29日 下午6:32:43
 * 
 */

public class LoginInterceptor implements HandlerInterceptor {

    /* (非 Javadoc) 
    * <p>Title: afterCompletion</p> 
    * <p>Description: </p> 
    * @param arg0
    * @param arg1
    * @param arg2
    * @param arg3
    * @throws Exception 
    * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception) 
    */ 
    
    
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        
        
    }

    /* (非 Javadoc) 
    * <p>Title: postHandle</p> 
    * <p>Description: </p> 
    * @param arg0
    * @param arg1
    * @param arg2
    * @param arg3
    * @throws Exception 
    * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView) 
    */ 
    
    
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

    /* (非 Javadoc) 
    * <p>Title: preHandle</p> 
    * <p>Description: </p> 
    * @param arg0
    * @param arg1
    * @param arg2
    * @return
    * @throws Exception 
    * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object) 
    */ 
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //得到请求的url
        String url = request.getRequestURI();
        //判断是否是公开地址
        //从配置文件中获取可以匿名访问的地址
        List<String> openUrlList = ResourcesUtil.getkeyList("anonymousUrl");
        //遍历公开地址
        for(String openUrl : openUrlList) {
            if(url.indexOf(openUrl) >= 0) {
                return true;
            }
        }
        
        //判断用户身份是否在session中存在
        HttpSession session = request.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        if(activeUser != null) {
            //如果存在则放行
            return true;
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        
        return false;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
