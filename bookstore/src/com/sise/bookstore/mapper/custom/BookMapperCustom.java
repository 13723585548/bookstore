/**   
* @Project:	bookstore
* @Title: BookMapperCustom.java
* @Package com.sise.bookstore.mapper.custom
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月30日 下午4:01:19
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sise.bookstore.model.entity.Book;
import com.sise.bookstore.pager.Expression;


/**
 * @ClassName: BookMapperCustom
 * @Description: 自定义图书查询接口
 * @author: zhiguo.lin
 * @date 2016年10月30日 下午4:01:19
 * 
 */

public interface BookMapperCustom {
    
  
    
    /** 
    * @Title: selectBookByPage 
    * @Description: 按条件查询图书（分页）
    * @param condition
    * @param categoryId
    * @param pageCode
    * @param pageSize
    * @return
    */ 
    
    public List<Book> selectBookByPage(@Param("condition") String condition, @Param("value") String value, 
            @Param("pageCode") int pageCode, @Param("pageSize") int pageSize); 
    
   
    /** 
    * @Title: selectTotalRecord 
    * @Description: 按条件查询总记录数
    * @param condition
    * @param value
    * @return
    */ 
    
    public int selectTotalRecord(@Param("condition") String condition, @Param("value") String value);
    
    /** 
    * @Title: selectBookByCombination 
    * @Description: 多条件组合查询（分页）
    * @param conditions
    * @param pageCode
    * @param pageSize
    * @return
    */ 
    
    public List<Book> selectBookByCombination(@Param("conditions") List<Expression> conditions,
            @Param("pageCode") int pageCode, @Param("pageSize") int pageSize);
    
    /** 
    * @Title: selectTotalRecordByCombination 
    * @Description: 多条件组合查询图书记录总数
    * @param conditions
    * @return
    */ 
    
    public int selectTotalRecordByCombination(@Param("conditions") List<Expression> conditions);


    /** 
    * @Title: selectBookCountByCategory 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    * @return
    */ 
    
    
    public int selectBookCountByCategory(@Param("categoryId") String categoryId);


    /** 
    * @Title: insertBook 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param book
    */ 
    
    
    public void insertBook(@Param("book") Book book);


    /** 
    * @Title: updateBook 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param book
    */ 
    
    
    public void updateBook(@Param("book") Book book);
}
