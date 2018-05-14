/**   
* @Project:	permission
* @Title: SysService.java
* @Package com.sise.ssm.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月29日 下午12:06:17
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import java.util.List;

import com.sise.bookstore.model.entity.SysPermission;
import com.sise.bookstore.model.entity.SysUser;
import com.sise.bookstore.model.pojo.ActiveUser;


/**
 * @ClassName: SysService
 * @Description: 系统服务类
 * @author: zhiguo.lin
 * @date 2016年9月29日 下午12:06:17
 * 
 */

public interface SysService {
    
    /** 
    * @Title: authenticat 
    * @Description: 根据用户身份和密码进行认证，认证通过，返回用户身份信息
    * @param userCode
    * @param password
    * @return
    * @throws Exception
    */ 
    
    public ActiveUser authenticat(String userCode, String password) throws Exception;
    
    /** 
    * @Title: findMenuListByUserId 
    * @Description: 根据用户id查询权限菜单
    * @param userId
    * @return
    * @throws Exception
    */ 
    
    public List<SysPermission> findMenuListByUserId(String userId) throws Exception;
    
    /** 
    * @Title: findPermissionListByUserId 
    * @Description: 根据用户id查询权限列表
    * @param userId
    * @return
    * @throws Exception
    */ 
    
    public List<SysPermission> findPermissionListByUserId(String userId) throws Exception; 
    
    /** 
    * @Title: findSysUserByUserCode 
    * @Description: 根据用户账号查询用户信息
    * @param userCode
    * @return
    * @throws Exception
    */ 
    
    public SysUser findSysUserByUserCode(String userCode) throws Exception;

}
