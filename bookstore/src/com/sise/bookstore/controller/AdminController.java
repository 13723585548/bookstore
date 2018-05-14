/**   
* @Project:	bookstore
* @Title: AdminController.java
* @Package com.sise.bookstore.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月16日 上午9:29:21
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.bookstore.model.entity.Admin;
import com.sise.bookstore.service.AdminService;


/**
 * @ClassName: AdminController
 * @Description: 管理员控制类
 * @author: zhiguo.lin
 * @date 2016年11月16日 上午9:29:21
 * 
 */
@Controller
public class AdminController {
    
    @Resource
    private AdminService adminService;
    
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin adminForm,HttpSession session, Model model) throws Exception {
        
        Admin admin = adminService.login(adminForm);
        
        if (admin == null) {
            model.addAttribute("userCodeError", "用户名或密码错误");
            return "backstage/login";
        }
        
        session.setAttribute("admin", admin);
        
        return "backstage/admin/index";
    }
    
    @RequestMapping(value = "/adminLogout")
    public String adminLogout(HttpSession session) throws Exception {
        
        session.removeAttribute("admin");
        
        return "backstage/login";
    }


}
