/**   
* @Project:	bookstore
* @Title: CatetoryServiceImpl.java
* @Package com.sise.bookstore.service.impl
* @Description: 用于做商品分类
* @author: zhiguo.lin   
* @date 2016年10月27日 下午1:55:09
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sise.bookstore.mapper.CategoryMapper;
import com.sise.bookstore.mapper.custom.CategoryMapperCustom;
import com.sise.bookstore.model.entity.Category;
import com.sise.bookstore.service.CategoryService;
import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: CatetoryServiceImpl
 * @Description: 用于做商品分类
 * @author: zhiguo.lin
 * @date 2016年10月27日 下午1:55:09
 * 
 */

@Service
public class CatetoryServiceImpl implements CategoryService {
  
    @Resource
    private CategoryMapper categoryMapper;
    
    @Resource
    private CategoryMapperCustom cateoryMapperCustom;

    /* (非 Javadoc) 
    * <p>Title: findAllCategory</p> 
    * <p>Description: </p> 
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#findAllCategory() 
    */ 
    
    
    @Override
    public List<Category> findAllCategory() throws Exception {
        
        /*
         * 1.查询所有顶级分类
         */
        List<Category> topCategoryList = cateoryMapperCustom.selectTopCategory();
        /*
         * 2.根据父分类查询子分类
         */
        for (Category topCategory : topCategoryList) {
            String parentId = topCategory.getId();
            List<Category> chlidren = cateoryMapperCustom.selectCategoryByParent(parentId);
            topCategory.setChildren(chlidren);
        }
        
        return topCategoryList;
    }

    /* (非 Javadoc) 
    * <p>Title: addCategory</p> 
    * <p>Description: </p> 
    * @param categoryForm
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#addCategory(com.sise.bookstore.model.entity.Category) 
    */ 
    
    
    @Override
    public void addCategory(Category categoryForm) throws Exception {
        
        categoryForm.setId(CommonUtils.uuid());
        
        cateoryMapperCustom.insertCategory(categoryForm);
    }

    /* (非 Javadoc) 
    * <p>Title: findFirstCategory</p> 
    * <p>Description: </p> 
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#findFirstCategory() 
    */ 
    
    
    @Override
    public List<Category> findFirstCategory() throws Exception {
       
        return  cateoryMapperCustom.selectTopCategory();
        
    }

    /* (非 Javadoc) 
    * <p>Title: updateCategory</p> 
    * <p>Description: </p> 
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#updateCategory() 
    */ 
    
    
    @Override
    public void updateCategory(Category category) throws Exception {
        
        cateoryMapperCustom.updateCategory(category);
        
    }

    /* (非 Javadoc) 
    * <p>Title: findCategoryById</p> 
    * <p>Description: </p> 
    * @param categoryId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#findCategoryById(java.lang.String) 
    */ 
    
    
    @Override
    public Category findCategoryById(String categoryId) throws Exception {
       
        return cateoryMapperCustom.selectCategoryById(categoryId);
    }

    /* (非 Javadoc) 
    * <p>Title: findChildrenCountByParent</p> 
    * <p>Description: </p> 
    * @param categoryId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#findChildrenCountByParent(java.lang.String) 
    */ 
    
    
    @Override
    public int findChildrenCountByParent(String parentId) throws Exception {
  
        return cateoryMapperCustom.selectChildrenCountByParent(parentId);
        
    }

    /* (非 Javadoc) 
    * <p>Title: deleteCategory</p> 
    * <p>Description: </p> 
    * @param categoryId
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#deleteCategory(java.lang.String) 
    */ 
    
    
    @Override
    public void deleteCategory(String categoryId) throws Exception {
        categoryMapper.deleteByPrimaryKey(categoryId);
    }

    /* (非 Javadoc) 
    * <p>Title: findChildrenByParent</p> 
    * <p>Description: </p> 
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CategoryService#findChildrenByParent() 
    */ 
    
    
    @Override
    public List<Category> findChildrenByParent(String parentId) throws Exception {
        
        List<Category> children = cateoryMapperCustom.selectCategoryByParent(parentId);
        
        return children;
    }



}
