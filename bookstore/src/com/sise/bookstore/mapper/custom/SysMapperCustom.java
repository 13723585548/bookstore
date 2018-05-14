/**   
* @Project:	permission
* @Title: SysMapperCustom.java
* @Package com.sise.ssm.mapper.custom
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月29日 下午8:20:14
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.mapper.custom;

import java.util.List;

import com.sise.bookstore.model.entity.SysPermission;


/**
 * @ClassName: SysMapperCustom
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年9月29日 下午8:20:14
 * 
 */

public interface SysMapperCustom {
    
    /** 
    * @Title: selectMenuListByUserId 
    * @Description: 根据用户id查询菜单列表
    * @param userId
    * @return
    */ 
    
    public List<SysPermission> selectMenuListByUserId(String userId); 
    
    /** 
    * @Title: selectPermissionListByUserId 
    * @Description: 根据用户id查询权限列表
    * @param userId
    * @return
    */ 
    
    public List<SysPermission> selectPermissionListByUserId(String userId);

}
