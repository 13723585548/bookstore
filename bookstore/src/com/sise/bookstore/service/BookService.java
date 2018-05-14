/**   
* @Project:	bookstore
* @Title: BookService.java
* @Package com.sise.bookstore.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月30日 下午3:19:19
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import com.sise.bookstore.model.entity.Book;
import com.sise.bookstore.pager.PageBean;


/**
 * @ClassName: BookService
 * @Description: 图书模块的业务功能服务类
 * @author: zhiguo.lin
 * @date 2016年10月30日 下午3:19:19
 * 
 */

public interface BookService {

     
    
    /** 
    * @Title: findBookByCondition 
    * @Description: 单条件查询 （分页）
    * @param condition
    * @param value
    * @param pageCode
    * @return
    * @throws Exception
    */ 
    
    public PageBean<Book> findBookByCondition(String condition, String value, int pageCode) throws Exception;
    

    /** 
    * @Title: findBookByCombination 
    * @Description: 多条件组合查询 （分页）
    * @param name
    * @param author
    * @param press
    * @param pageCode
    * @return
    * @throws Exception
    */ 
    
    public PageBean<Book> findBookByCombination(String name, String author, String press, int pageCode) throws Exception ;
    
    /** 
    * @Title: findBookById 
    * @Description: 按id查询 
    * @param bookId
    * @return
    * @throws Exception
    */ 
    
    public Book findBookById(String bookId) throws Exception;


    /** 
    * @Title: findBookCountByCategory 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param categoryId
    * @return
    */ 
    
    
    public int findBookCountByCategory(String categoryId) throws Exception;


    /** 
    * @Title: add 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param book
    */ 
    
    
    public void addBook(Book book) throws Exception;


    /** 
    * @Title: updateBook 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param book
    */ 
    
    
    public void updateBook(Book book) throws Exception;


    /** 
    * @Title: delete 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param id
    */ 
    
    
    public void delete(String id) throws Exception;
    
}
