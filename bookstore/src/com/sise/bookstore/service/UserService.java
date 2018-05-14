/**   
* @Project:	bookstore
* @Title: UserService.java
* @Package com.sise.bookstore.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月13日 上午9:46:52
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import com.sise.bookstore.controller.model.UserForm;
import com.sise.bookstore.model.entity.User;


/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年10月13日 上午9:46:52
 * 
 */

public interface UserService {
    
    /** 
     * @Title: isRegistered 
     * @Description: 检查用户是否已注册
     * @return
     * @throws Exception
     */ 
     
     public boolean checkUser(String userCode) throws Exception;
     
     /** 
    * @Title: checkEmail 
    * @Description: 检查email是否已被注册
    * @param email
    * @return
    * @throws Exception
    */ 
    
    public boolean checkEmail(String email) throws Exception;

    /** 
    * @Title: regist 
    * @Description: 注册用户
    * @throws Exception
    */ 
    
    public void regist(UserForm userForm) throws  Exception;
    
    
    /** 
    * @Title: findUserByUserCode 
    * @Description: 根据用户账号查找用户
    * @param userCode
    * @return
    * @throws Exception
    */ 
    
    public User findUserByUserCode(String userCode) throws Exception;
    
    /** 
    * @Title: findUserByUserCodeAndPassword 
    * @Description: 根据用户id和密码查找用户
    * @param userCode
    * @param password
    * @return
    * @throws Exception
    */ 
    
    public boolean findUserByUserCodeAndPassword(String userId, String password) throws Exception;
    
    /** 
    * @Title: updatePassword 
    * @Description: 修改密码
    * @throws Exception
    */ 
    
    public void updatePassword(String userId, String oldPassword, String salt, String newPassword) throws Exception;
    
    
    
}
