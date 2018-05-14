/**   
* @Project:	bookstore
* @Title: UserController.java
* @Package com.sise.bookstore.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月13日 上午10:01:01
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sise.bookstore.controller.model.UserForm;
import com.sise.bookstore.model.pojo.ActiveUser;
import com.sise.bookstore.service.UserService;


/**
 * @ClassName: UserController
 * @Description: 用户模块业务调度
 * @author: zhiguo.lin
 * @date 2016年10月13日 上午10:01:01
 * 
 */

@Controller
public class UserController {
    
    @Resource
    private UserService userService;
    
    
    /** 
    * @Title: regist 
    * @Description: 用户注册
    * @param userForm
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(UserForm userForm, HttpSession session, Model model) throws Exception {
   
        Map<String, String> errors = validateRegister(userForm, session);
        if(errors.size() > 0) {
            model.addAttribute("errors", errors);
            return "user/register";           
        }
        
        userService.regist(userForm);
        model.addAttribute("code", "success");
        model.addAttribute("btn", "login");
        model.addAttribute("msg", "注册成功，请马上到邮箱激活！");

        return "msg";
    }
    
    
    /** 
    * @Title: validateRegister 
    * @Description: 注册校验
    * @param userForm
    * @param session
    * @return
    * @throws Exception
    */ 
    
    public Map<String, String> validateRegister(UserForm userForm, HttpSession session) throws Exception {
   
        Map<String,String> errors = new HashMap<String,String>();
        
        /*
         *  校验用户名
         */
        String userCode = userForm.getUserCode();
        if (StringUtils.isBlank(userCode)) {
            errors.put("userCode", "用户名不能为空");
        } else if (userCode.length() < 3 || userCode.length() > 18) {
            errors.put("userCode", "用户名长度必须在3~18个字符之间");
        } else if (userService.checkUser(userCode)) {
            errors.put("userCode", "用户名已被注册");
        }
        
        /*
         * 校验登录密码
         */
        String password = userForm.getPassword();
        if (StringUtils.isBlank(password)) {
            errors.put("password", "密码不能为空");
        } else if (password.length() < 6 || password.length() >15) {
            errors.put("password", "密码长度必须在6~15个字符之间");
        }
        
        /*
         * 校验确认密码
         */
        String confirmPassword = userForm.getConfirmPassword();
        if (StringUtils.isBlank(confirmPassword)) {
            errors.put("confirmPassword", "确认密码不能为空");
        } else if (!confirmPassword.equals(password)) {
            errors.put("confirmPassword", "两次输入密码不一致");
        }
        
        /*
         * 校验邮箱
         */
        String email = userForm.getEmail();
        if (StringUtils.isBlank(email)) {
            errors.put("email", "邮箱不能为空");
        } else if (!email.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")) {
            errors.put("email", "请输入一个正确的邮箱");
        } else  if (userService.checkEmail(email)) {
            errors.put("email", "邮箱已被注册");
        }
        
        /*
         *  校验验证码
         */            
        String verifyCode = userForm.getVerifyCode();
        if(StringUtils.isBlank(verifyCode)) {
            errors.put("verifyCode", "验证码不能为空");
        } else if (!testVerifyCode(verifyCode,session)) {
            errors.put("verifyCode", "验证码错误");           
        }
        
        return errors;
        
        
    }
       
    /** 
    * @Title: checkUser 
    * @Description: 校验用户是否已注册
    * @param loginname
    * @param response
    * @throws Exception
    */ 
    
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public void checkUser(String userCode, HttpServletResponse response) throws Exception {
        
        boolean isRegistered = userService.checkUser(userCode);
        
        response.getWriter().print(!isRegistered);
 
    }
    
    
    /** 
    * @Title: checkEmail 
    * @Description: 校验email是否已注册
    * @param email
    * @param response
    * @throws Exception
    */ 
    
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public void checkEmail(String email, HttpServletResponse response) throws Exception {
        
        boolean isRegistered = userService.checkEmail(email);
        
        response.getWriter().print(!isRegistered);
        
    }
    
    /** 
    * @Title: checkVerifyCode 
    * @Description: 校验验证码是否正确
    * @param verifyCode
    * @param session
    * @param response
    * @throws Exception
    */ 
    
    @RequestMapping(value = "/checkVerifyCode", method = RequestMethod.POST)
    public void checkVerifyCode(String verifyCode, HttpSession session, HttpServletResponse response) throws Exception {
        
       boolean isCorrect = testVerifyCode(verifyCode, session);
       
       response.getWriter().print(isCorrect);
            
    }

    /** 
    * @Title: testVerifyCode 
    * @Description: 校验验证码是否正确
    * @param verifyCode
    * @param session
    * @return
    */ 
    
    private boolean testVerifyCode(String verifyCode, HttpSession session) {
        
        String sessionVerifyCode = (String) session.getAttribute("verifyCode");
           
        boolean isCorrect  = false;
           
        if(StringUtils.isNotBlank(verifyCode) && StringUtils.isNotBlank(sessionVerifyCode)  && 
                verifyCode.equalsIgnoreCase(sessionVerifyCode)){
            
            isCorrect = true;
        }
       
        return isCorrect;
    }
    
    /** 
    * @Title: updatePassword 
    * @Description: 修改密码
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value="updatePassword", method = RequestMethod.POST)
    public String updatePassword(UserForm userForm, Model model) throws Exception {
        
        /*
         * 1.数据校验
         */
        
        /*
         * 2.修改密码
         */
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        
        userService.updatePassword(activeUser.getUserId(), userForm.getPassword(), activeUser.getSalt(), userForm.getNewPassword());
        
        model.addAttribute("code", "success");
        model.addAttribute("btn", "logout");
        model.addAttribute("msg", "密码修改成功！");
        

        return "msg";
    }
    
}
