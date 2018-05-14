/**   
* @Project:	bookstore
* @Title: UserForm.java
* @Package com.sise.bookstore.controller.form
* @Description: 封装user表单数据
* @author: zhiguo.lin   
* @date 2016年10月14日 上午9:04:54
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller.model;

import javax.validation.constraints.Size;



/**
 * @ClassName: UserForm
 * @Description: 用户表单javabean
 * @author: zhiguo.lin
 * @date 2016年10月14日 上午9:04:54
 * 
 */

public class UserForm {
    
    @Size(min = 3, max =18)
    private String userCode;
    
    @Size(min = 6, max =15)
    private String password;
    
    private String confirmPassword;
    
    private String email;
    
    private String verifyCode;
    
    private String newPassword;

  
    public String getUserCode() {
        return userCode;
    }

    
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    
    public String getPassword() {
        return password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getConfirmPassword() {
        return confirmPassword;
    }

    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getVerifyCode() {
        return verifyCode;
    }

    
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }


    
    public String getNewPassword() {
        return newPassword;
    }


    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    
    
    

}
