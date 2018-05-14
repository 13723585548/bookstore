/**   
* @Project:	bookstore
* @Title: UserServiceImpl.java
* @Package com.sise.bookstore.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月13日 上午9:48:34
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.bookstore.controller.model.UserForm;
import com.sise.bookstore.mapper.UserMapper;
import com.sise.bookstore.model.entity.User;
import com.sise.bookstore.model.entity.UserExample;
import com.sise.bookstore.model.entity.UserExample.Criteria;
import com.sise.bookstore.service.UserService;
import com.sise.bookstore.util.MD5;
import com.sise.bookstore.util.RandomSalt;
import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年10月13日 上午9:48:34
 * 
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;



    /* (非 Javadoc) 
    * <p>Title: checkUser</p> 
    * <p>Description: 检查用户是否已被注册</p> 
    * @param loginname
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.UserService#checkUser(java.lang.String) 
    */ 
    
    @Override
    public boolean checkUser(String userCode) throws Exception {
        
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        criteria.andUserCodeEqualTo(userCode);

        
        List<User> userList = userMapper.selectByExample(userExample);        
        
        if(userList != null && userList.size() != 0) {
            return true;
        }
        
        return false;
    }
    
    /* (非 Javadoc) 
    * <p>Title: checkEmail</p> 
    * <p>Description: 检查email是否已被注册</p> 
    * @param email
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.UserService#checkEmail(java.lang.String) 
    */ 
    
    public boolean checkEmail(String email) throws Exception {
        
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        
        List<User> userList = userMapper.selectByExample(userExample); 
        
        if(userList != null && userList.size() != 0) {
            return true;
        }
        
        return false;
        
    }

    /* (非 Javadoc) 
     * <p>Title: regist</p> 
     * <p>Description: 注册用户</p> 
     * @throws Exception 
     * @see com.sise.bookstore.service.UserService#regist() 
     */

    @Override
    public void regist(UserForm userForm) throws Exception {
        //把表单bean转成实体bean
        User user = userFormToUser(userForm);
        //持久化
        userMapper.insert(user);
        //发送邮件
        //sendMail(user);
    }

    /** 
    * @Title: userFormToUser 
    * @Description: 表单bean转实体bean
    * @param userForm
    * @return
     * @throws IOException 
    */ 
    
    
    private User userFormToUser(UserForm userForm) throws Exception {
        
        User user = new User();
        //生成随机盐
        String salt = RandomSalt.getStringRandom(8);           
        //密码加密
        String password  = MD5.getMd5(userForm.getPassword(), salt);
        //复制属性userForm到user
        BeanUtils.copyProperties(userForm, user);
        user.setPassword(password);
        user.setSalt(salt);
        user.setId(CommonUtils.uuid());
        user.setStatus(false);
        user.setActivationCode(CommonUtils.uuid());
        return user;
    }

    /* (非 Javadoc) 
    * <p>Title: findUserByUserCode</p> 
    * <p>Description: </p> 
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.UserService#findUserByUserCode() 
    */ 
    
    
    @Override
    public User findUserByUserCode(String userCode) throws Exception {
        
        UserExample userExample = new UserExample();
        Criteria criteria = userExample.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList != null && userList.size() != 0) {
            return userList.get(0);
        }
        return null;
    }

    /* (非 Javadoc) 
    * <p>Title: updatePassword</p> 
    * <p>Description: </p> 
    * @param userId
    * @param password
    * @throws Exception 
    * @see com.sise.bookstore.service.UserService#updatePassword(java.lang.String, java.lang.String) 
    */ 
    
    
    @Override
    public void updatePassword(String userId, String oldPassword, String salt, String newPassword) throws Exception {
     
        //查找用户
        if(!findUserByUserCodeAndPassword(userId,MD5.getMd5(oldPassword, salt))) {
            throw new RuntimeException("原密码错误");
        }
        //修改密码
        User user = userMapper.selectByPrimaryKey(userId);
        String newSalt = RandomSalt.getStringRandom(8);
        String password = MD5.getMd5(newPassword, newSalt);
        user.setPassword(password);
        user.setSalt(newSalt);
        userMapper.updateByPrimaryKey(user);
        
    }
    
    /* (非 Javadoc) 
     * <p>Title: findUserByUserCodeAndPassword</p> 
     * <p>Description: </p> 
     * @param userId
     * @param password
     * @return
     * @throws Exception 
     * @see com.sise.bookstore.service.UserService#findUserByUserCodeAndPassword(java.lang.String, java.lang.String) 
     */ 
     
     
     @Override
     public boolean findUserByUserCodeAndPassword(String userId, String password) throws Exception {
         UserExample userExample = new UserExample();
         Criteria criteria = userExample.createCriteria();
         criteria.andIdEqualTo(userId);
         criteria.andPasswordEqualTo(password);
         List<User> userList = userMapper.selectByExample(userExample);
         
         if(userList != null && userList.size() != 0) {
             return true;
         }
         
         return false;
     }

    /** 
    * @Title: sendMail 
    * @Description: 发送邮件
    * @param user
    * @throws IOException
    * @throws MessagingException
    */ 
    
    
   /* private void sendMail(User user) throws IOException, MessagingException {
        //加载邮件模板
        Properties prop = new Properties();
        prop.load(this.getClass().getClassLoader().getResourceAsStream("emailTemplate.properties"));
        
         * 登录邮件服务器，得到session
         
        String host = prop.getProperty("host");//服务器主机名
        String name = prop.getProperty("username");//登录名
        String pass = prop.getProperty("password");//登录密码
        Session session = MailUtils.createSession(host, name, pass); 
        
         * 创建Mail对象
         
        String from = prop.getProperty("from");
        String to = user.getEmail();
        String subject = prop.getProperty("subject");
        String content = MessageFormat.format(prop.getProperty("content"), user.getActivationCode());
        Mail mail = new Mail(from, to, subject, content);
        //发送邮件
        MailUtils.send(session, mail);
    }*/
  
}
