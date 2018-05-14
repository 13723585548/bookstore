/**   
* @Project:	bookstore
* @Title: CategoryService.java
* @Package com.sise.bookstore.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月27日 下午1:52:59
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import java.util.List;

import com.sise.bookstore.model.entity.Category;


/**
 * @ClassName: CategoryService
 * @Description: 分类服务类
 * @author: zhiguo.lin
 * @date 2016年10月27日 下午1:52:59
 * 
 */

public interface CategoryService {
     
    /** 
    * @Title: findAllCategory 
    * @Description: 查询所有分类
    * @return
    * @throws Exception
    */ 
    
    public List<Category> findAllCategory() throws Exception;

    /** 
    * @Title: addCategory 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryForm
    */ 
    
    
    public void addCategory(Category categoryForm) throws Exception;

    /** 
    * @Title: findFirstCategory 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @return
    */ 
    
    
    public List<Category> findFirstCategory() throws Exception;

    
    
    /** 
    * @Title: updateCategory 
    * @Description: 更新分类
    * @param categoryId
    * @throws Exception
    */ 
    
    public void updateCategory(Category category) throws Exception;

    /** 
    * @Title: findCategoryById 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    */ 
    
    
    public Category findCategoryById(String categoryId) throws Exception;

    /** 
    * @Title: findChildrenCountByParent 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    * @return
    */ 
    
    
    public int findChildrenCountByParent(String parentId) throws Exception;

    /** 
    * @Title: deleteCategory 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    */ 
    
    
    public void deleteCategory(String categoryId) throws Exception;

    /** 
    * @Title: findChildrenByParent 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @return
    */ 
    
    
    public List<Category> findChildrenByParent(String parentId) throws Exception;


}
