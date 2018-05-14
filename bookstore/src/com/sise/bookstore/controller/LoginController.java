/**   
* @Project:	permission
* @Title: LoginController.java
* @Package com.sise.bookstore.controller;
* @Description: 登录控制类
* @author: zhiguo.lin   
* @date 2016年9月29日 下午2:09:32
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.bookstore.exception.UnknownException;
import com.sise.bookstore.model.pojo.ActiveUser;




/**
 * @ClassName: LoginController
 * @Description: 登录控制类
 * @author: zhiguo.lin
 * @date 2016年9月29日 下午2:09:32
 * 
 */

@Controller
public class LoginController {    
    
    @RequestMapping("login")
    public String login(HttpServletRequest request,Model model) throws Exception {
        
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        
        if (exceptionClassName != null) {
            
            if ("userCodeError".equals(exceptionClassName)) {
                model.addAttribute("userCodeError", "用户名必须在3~18个字符之间");
            } else if ("passwordError".equals(exceptionClassName)) {
                model.addAttribute("passwordError", "密码长度必须在6~15个字符之间");
            } else if ("verifyCodeError".equals(exceptionClassName)) {
                model.addAttribute("verifyCodeError", "验证码错误");
            } else if (UnknownAccountException.class.getName().equals(exceptionClassName)) {              
                model.addAttribute("userCodeError", "账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                model.addAttribute("passwordError", "密码错误");
            } else {
                throw new UnknownException("未知错误");
            }
         }

        return "user/login";
    }
    
    /** 
    * @Title: home 
    * @Description: 转向系统首页
    * @param model
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping("/home")
    public String home(Model model) throws Exception {
        
        Subject subject = SecurityUtils.getSubject();
        
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        
        model.addAttribute("activeUser", activeUser);
        
        return "home/index";
    }
    
    /*@RequestMapping("/reLogin")
    public String reLogin(HttpSession session) throws Exception {
        
        session.removeAttribute("currentUser");
        
        return "user/login";
    }*/

}
