/**   
* @Project:	bookstore
* @Title: AdminService.java
* @Package com.sise.bookstore.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月16日 上午9:36:01
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import com.sise.bookstore.model.entity.Admin;


/**
 * @ClassName: AdminService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月16日 上午9:36:01
 * 
 */

public interface AdminService {
    
    /** 
    * @Title: login 
    * @Description: 登录
    * @return
    * @throws Exception
    */ 
    
    public Admin login(Admin adminForm) throws Exception;

}
