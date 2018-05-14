/**   
* @Project:	permission
* @Title: ActiveUser.java
* @Package com.sise.ssm.model.pojo
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月29日 上午11:40:27
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.model.pojo;

import java.io.Serializable;
import java.util.List;

import com.sise.bookstore.model.entity.SysPermission;


/**
 * @ClassName: ActiveUser
 * @Description: 用于记录当前用户身份信息
 * @author: zhiguo.lin
 * @date 2016年9月29日 上午11:40:27
 * 
 */

public class ActiveUser implements Serializable{

    /**
    * @Fields serialVersionUID : 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性
    */
    
    private static final long serialVersionUID = 3746737018328147326L;

    private String userId;
    
    private String username;
    
    private String userCode;
    
    private String password;
    
    private String salt;
    
    private List<SysPermission> menuList;
    
    private List<SysPermission> permissionList;
    
      
    public String getUserId() {
        return userId;
    }

    
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    
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


    
    public List<SysPermission> getMenuList() {
        return menuList;
    }


    
    public void setMenuList(List<SysPermission> menuList) {
        this.menuList = menuList;
    }


    
    public List<SysPermission> getPermissionList() {
        return permissionList;
    }


    
    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }


    
    public String getSalt() {
        return salt;
    }


    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    
   
}
