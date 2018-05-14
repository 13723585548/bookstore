/**   
* @Project:	bookstore
* @Title: AdminServiceImpl.java
* @Package com.sise.bookstore.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月16日 上午9:37:37
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.sise.bookstore.mapper.AdminMapper;
import com.sise.bookstore.model.entity.Admin;
import com.sise.bookstore.model.entity.AdminExample;
import com.sise.bookstore.model.entity.AdminExample.Criteria;
import com.sise.bookstore.service.AdminService;


/**
 * @ClassName: AdminServiceImpl
 * @Description: 管理员业务实现类
 * @author: zhiguo.lin
 * @date 2016年11月16日 上午9:37:37
 * 
 */

@Service
public class AdminServiceImpl implements AdminService {
    
    @Resource
    private AdminMapper adminMapper;

    /* (非 Javadoc) 
     * <p>Title: login</p> 
     * <p>Description: </p> 
     * @param adminForm
     * @return
     * @throws Exception 
     * @see com.sise.bookstore.service.AdminService#login(com.sise.bookstore.model.entity.Admin) 
     */

    @Override
    public Admin login(Admin adminForm) throws Exception {
        
        AdminExample adminExample = new AdminExample();
        Criteria criteria = adminExample.createCriteria();
        criteria.andNameEqualTo(adminForm.getName());
        
        Md5Hash md5Hash = new Md5Hash(adminForm.getPassword(), "qwerty", 2);
        
        String md5Password = md5Hash.toString();
        
        criteria.andPasswordEqualTo(md5Password);
        
        List<Admin> admin = adminMapper.selectByExample(adminExample);
        
        if(admin != null && admin.size() != 0) {
            return admin.get(0);
        }
        
        return null;
    }

}
