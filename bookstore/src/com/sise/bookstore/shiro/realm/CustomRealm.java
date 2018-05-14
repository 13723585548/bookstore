/**   
* @Project:	shiro
* @Title: RealmTest.java
* @Package com.sise.shiro.authentication
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月23日 下午2:06:52
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.shiro.realm;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import com.sise.bookstore.model.entity.User;
import com.sise.bookstore.model.pojo.ActiveUser;
import com.sise.bookstore.service.UserService;


/**
 * @ClassName: RealmTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月23日 下午2:06:52
 * 
 */

public class CustomRealm extends AuthorizingRealm {
    
    @Resource
    private UserService userService;

    /* (非 Javadoc) 
     * <p>Title: doGetAuthenticationInfo</p> 
     * <p>Description: </p> 
     * @param arg0
     * @return
     * @throws AuthenticationException 
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken) 
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        
        //获取身份信息
        String userCode = (String) token.getPrincipal();
        
        if(StringUtils.isBlank(userCode)) {
            return null; 
        }
        
        User user = null;
        try {
            user = userService.findUserByUserCode(userCode);
        } catch (Exception e) {
           //throw new UnknownException("未知错误");
        }
       
        if(user == null) {
            return null;
        }
        
        String password = user.getPassword();
        String salt = user.getSalt();
        
        
        //设置用户身份信息
        ActiveUser activeUser = new ActiveUser();
        activeUser.setUserId(user.getId());
        activeUser.setUserCode(user.getUserCode());
        activeUser.setSalt(salt);
        
       //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo =  new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(salt), this.getName());
        
        Subject subject = SecurityUtils.getSubject(); 

        Session session = subject.getSession();
        
        session.setAttribute("currentUser", activeUser);
        
        return simpleAuthenticationInfo;
        
    }

    
    /* (非 Javadoc) 
    * <p>Title: doGetAuthorizationInfo</p> 
    * <p>Description: </p> 
    * @param principals
    * @return 
    * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection) 
    */ 
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
