/**   
* @Project:	permission
* @Title: PermissionInterceptor.java
* @Package com.sise.ssm.interceptor
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月30日 上午11:45:12
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

import com.sise.bookstore.exception.ParameterException;
import com.sise.bookstore.model.entity.SysPermission;
import com.sise.bookstore.model.pojo.ActiveUser;
import com.sise.bookstore.util.ResourcesUtil;


/**
 * @ClassName: PermissionInterceptor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月30日 上午11:45:12
 * 
 */

public class PermissionInterceptor implements HandlerInterceptor {

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
        
        //从配置文件中获取公共访问地址（即认证通过即可访问的地址）
        List<String> commonUrlList = ResourcesUtil.getkeyList("commonUrl");
        //遍历公共访问地址
        for(String commonUrl : commonUrlList) {
            if(commonUrl.indexOf(url) >= 0 ) {
                //如果是公共访问地址，则放行
                return true;
            }
        }
        
        HttpSession session = request.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        //获取用户的权限列表
        List<SysPermission> permissionList = activeUser.getPermissionList();
        for(SysPermission permission : permissionList) {

            String permissionUrl = permission.getUrl(); 
            if (("".equals(permissionUrl)) || (permissionUrl == null)) {
                   throw new ParameterException("地址不存在");
            }
            
            
            if(!("".equals(permissionUrl)) && !(permissionUrl == null)) {  
                if(url.indexOf(permission.getUrl()) >= 0) {
                    return true;
                }
            }
        }     
        
        request.getRequestDispatcher("/WEB-INF/jsp/refuse.jsp").forward(request, response);
        
        return false;
    }

}
