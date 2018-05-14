/**   
* @Project:	bookstore
* @Title: CategoryMapperCustom.java
* @Package com.sise.bookstore.mapper.custom
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月27日 下午1:56:22
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sise.bookstore.model.entity.Category;


/**
 * @ClassName: CategoryMapperCustom
 * @Description: 自定义分类Mapper接口，完成分类的一些特殊查询
 * @author: zhiguo.lin
 * @date 2016年10月27日 下午1:56:22
 * 
 */

public interface CategoryMapperCustom {

    /** 
    * @Title: selectTopCategory 
    * @Description: 查询顶级分类
    * @return
    */ 
    
    public List<Category> selectTopCategory();
    
    /** 
    * @Title: selectCategoryByParent 
    * @Description: 根据父分类查询子分类
    * @param parentId
    * @return
    */ 
    
    public List<Category> selectCategoryByParent(String parentId);
    
    
    /** 
    * @Title: insertCategory 
    * @Description: 添加分类
    * @param category
    */ 
    
    public void insertCategory(@Param("category") Category category);

    /** 
    * @Title: update 
    * @Description: 更新分类
    * @param category
    */ 
    
    
    public void updateCategory(@Param("category") Category category);

    /** 
    * @Title: selectCategoryById 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    * @return
    */ 
    
    
    public Category selectCategoryById(@Param("categoryId") String categoryId);

    /** 
    * @Title: selectChildrenCountByParent 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    * @return
    */ 
    
    
    public int selectChildrenCountByParent(@Param("parentId") String parentId);

 
    
}
