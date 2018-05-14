/**   
* @Project:	bookstore
* @Title: BookServiceImpl.java
* @Package com.sise.bookstore.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月30日 下午3:22:27
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sise.bookstore.mapper.BookMapper;
import com.sise.bookstore.mapper.custom.BookMapperCustom;
import com.sise.bookstore.model.entity.Book;
import com.sise.bookstore.pager.Expression;
import com.sise.bookstore.pager.PageBean;
import com.sise.bookstore.service.BookService;
import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: BookServiceImpl
 * @Description: 图书操作服务类
 * @author: zhiguo.lin
 * @date 2016年10月30日 下午3:22:27
 * 
 */

@Service
public class BookServiceImpl implements BookService {
    
    @Resource
    private BookMapperCustom bookMapperCustom;
    
    @Resource
    private BookMapper bookMapper;

  
    /* (非 Javadoc) 
    * <p>Title: findBookByCondition</p> 
    * <p>Description: </p> 
    * @param condition
    * @param value
    * @param pageCode
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#findBookByCondition(java.lang.String, java.lang.String, int) 
    */ 
    
    @Override
    public PageBean<Book> findBookByCondition(String condition, String value, int pageCode) throws Exception {
        
        int pageSize = getPageSize();
        
        //获取每页的数据
        List<Book> bookList = bookMapperCustom.selectBookByPage(condition, value, (pageCode -1) * pageSize, pageSize);
        
        //获取总记录数
        int totalRecord  = bookMapperCustom.selectTotalRecord(condition, value);
        
        PageBean<Book> pageBean = new PageBean<Book>();
        
        pageBean.setPageCode(pageCode);
        
        pageBean.setPageSize(pageSize);
        
        pageBean.setTotalRecord(totalRecord);
        
        pageBean.setRecords(bookList);
    
        return pageBean;
    }

    /** 
    * @Title: getPageSize 
    * @Description: 读取配置文件的pageSize属性
    * @return
    * @throws IOException
    */ 
    
    
    private int getPageSize() throws IOException {
        
        Properties prop = new Properties();
        
        prop.load(this.getClass().getClassLoader().getResourceAsStream("pager.properties"));
        
        int pageSize = Integer.parseInt(prop.getProperty("pageSize"));
        
        return pageSize;
    }

    /* (非 Javadoc) 
    * <p>Title: findBookByCombination</p> 
    * <p>Description: </p> 
    * @param pageCode
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#findBookByCombination(int) 
    */ 
    
    
    @Override
    public PageBean<Book> findBookByCombination(String name, String author, String press, int pageCode) throws Exception {
        
        int pageSize = getPageSize();
       
        List<Expression> conditions = new ArrayList<Expression>();
        
        if (StringUtils.isNotBlank(name)){
            conditions.add( new Expression("name", "like", name));
        }
        if (StringUtils.isNotBlank(author)) {
            conditions.add(new Expression("author", "like", author));
        }
        if (StringUtils.isNotBlank(press)) {
            conditions.add(new Expression("press", "like", press));
        }
 
        List<Book> bookList = bookMapperCustom.selectBookByCombination(conditions, (pageCode - 1) * pageSize, pageSize);
        
        int totalRecord  = bookMapperCustom.selectTotalRecordByCombination(conditions);
        
        PageBean<Book> pageBean = new PageBean<Book>();
        
        pageBean.setPageCode(pageCode);
        
        pageBean.setPageSize(pageSize);
        
        pageBean.setTotalRecord(totalRecord);
        
        pageBean.setRecords(bookList);
        
        return pageBean;
    }

    /* (非 Javadoc) 
    * <p>Title: findBookById</p> 
    * <p>Description: </p> 
    * @param bookId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#findBookById(java.lang.String) 
    */ 
    
    
    @Override
    public Book findBookById(String bookId) throws Exception {
        
        Book book = bookMapper.selectByPrimaryKey(bookId);
        
        return book;
    }

    /* (非 Javadoc) 
    * <p>Title: findBookCountByCategory</p> 
    * <p>Description: </p> 
    * @param categoryId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#findBookCountByCategory(java.lang.String) 
    */ 
    
    
    @Override
    public int findBookCountByCategory(String categoryId) throws Exception {
        
        return bookMapperCustom.selectBookCountByCategory(categoryId);
    }

    /* (非 Javadoc) 
    * <p>Title: add</p> 
    * <p>Description: </p> 
    * @param book
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#add(com.sise.bookstore.model.entity.Book) 
    */ 
    
    
    @Override
    public void addBook(Book book) throws Exception {
        
        book.setId(CommonUtils.uuid());
        bookMapperCustom.insertBook(book);
    }

    /* (非 Javadoc) 
    * <p>Title: updateBook</p> 
    * <p>Description: </p> 
    * @param book
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#updateBook(com.sise.bookstore.model.entity.Book) 
    */ 
    
    
    @Override
    public void updateBook(Book book) throws Exception {
        
        bookMapperCustom.updateBook(book);
        
    }

    /* (非 Javadoc) 
    * <p>Title: delete</p> 
    * <p>Description: </p> 
    * @param id
    * @throws Exception 
    * @see com.sise.bookstore.service.BookService#delete(java.lang.String) 
    */ 
    
    
    @Override
    public void delete(String id) throws Exception {
        bookMapper.deleteByPrimaryKey(id);
    }

}
