/**   
* @Project:	bookstore
* @Title: BookController.java
* @Package com.sise.bookstore.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月30日 下午4:50:14
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sise.bookstore.model.entity.Book;
import com.sise.bookstore.pager.PageBean;
import com.sise.bookstore.service.BookService;


/**
 * @ClassName: BookController
 * @Description: 图书控制类
 * @author: zhiguo.lin
 * @date 2016年10月30日 下午4:50:14
 * 
 */

@Controller
public class BookController {

    @Resource
    private BookService bookServie;
    
    @RequestMapping(value="findBookByCondition")
    public String findBookByCondition(String condition, String value, Model model, HttpServletRequest request,
            @RequestParam(value="pageCode", defaultValue = "1") int pageCode) throws Exception {
          

        PageBean<Book> pageBean = bookServie.findBookByCondition(condition, value, pageCode);
              
        pageBean.setUrl(getUrl(request));        
    
        model.addAttribute("pageBean", pageBean);
        
        return "book/list";
    }
    
    /** 
    * @Title: getUrl 
    * @Description: 获取请求url
    * @param request
    * @return
    */ 
    
    private String getUrl(HttpServletRequest request) {
        //request.getRequestURI()返回全路径；  request.getQueryString()获取带参数查询字符串
    	String url = request.getRequestURI() + "?" + request.getQueryString();
       
        int index = url.lastIndexOf("&pageCode=");
        if(index != -1) {
            url = url.substring(0, index);
        }
        return url;
    }
    
    /** 
    * @Title: findBookByCombination 
    * @Description: 多条件组合查询
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value="findBookByCombination")
    public String findBookByCombination(String name, String author, String press, Model model, HttpServletRequest request,
            @RequestParam(value="pageCode", defaultValue = "1") int pageCode) throws Exception {
        
        PageBean<Book> pageBean = bookServie.findBookByCombination(name, author, press, pageCode);
        
        pageBean.setUrl(getUrl(request));   
        
        model.addAttribute("pageBean", pageBean);
        
        return "book/list";
    }
    
    /** 
    * @Title: findBookById 
    * @Description: 按id查询
    * @param id
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value="findBookById")
    public String findBookById(String bookId, Model model) throws Exception {
        
        Book book = bookServie.findBookById(bookId);
        
        model.addAttribute("book", book);
        
        return "book/detail";
    }
    
}
