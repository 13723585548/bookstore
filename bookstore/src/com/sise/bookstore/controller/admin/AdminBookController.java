/**   
 * @Project:	bookstore
 * @Title: AdminBookController.java
 * @Package com.sise.bookstore.controller.admin
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: zhiguo.lin   
 * @date 2016年11月20日 上午9:37:00
 * @CopyRight: CopyRight@2016
 * @version V1.0   
 */

package com.sise.bookstore.controller.admin;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sise.bookstore.model.entity.Book;
import com.sise.bookstore.model.entity.Category;
import com.sise.bookstore.pager.PageBean;
import com.sise.bookstore.service.BookService;
import com.sise.bookstore.service.CategoryService;

/**
 * @ClassName: AdminBookController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月20日 上午9:37:00
 */
@RequestMapping("/admin")
@Controller
public class AdminBookController {

    @Resource
    private CategoryService categoryService;
    
    @Resource
    private BookService bookService; 

    @RequestMapping(value = "addPrepare")
    public String addPrepare(Model model) throws Exception {

        List<Category> parents = categoryService.findFirstCategory();
        
        model.addAttribute("parents", parents);
        
        return "backstage/admin/book/add";
    }
    
    @RequestMapping(value = "ajaxFindChildren", method = RequestMethod.POST)
    public @ResponseBody List<Category> ajaxFindChildren(String parentId) throws Exception {
        List<Category> children = categoryService.findChildrenByParent(parentId);
        return children;
    }
    
    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    public String addBook(Book book,Model model) throws Exception {
        
        bookService.addBook(book);
        model.addAttribute("code", "success");
        model.addAttribute("msg", "添加成功");
        
        return "backstage/msg";
    }
    
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    public @ResponseBody String uploadImage(HttpServletRequest request, MultipartFile image) throws Exception {
        
        if (image == null) {
            //图片不能为空
            throw new Exception("图片不能为空");
        }    
        
        String originalFilename = image.getOriginalFilename();
        
        String relativePath = "";
        
        if (image != null && originalFilename != null && originalFilename.length() > 0) {
            
            String savePath = request.getServletContext().getRealPath("/book_img");
            
            String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf('.'));
            
            File file = new File(savePath + newFilename);
            
            image.transferTo(file);
            
            relativePath = "book_img/" + newFilename;
        }
       
        return relativePath;
    }
    
    @RequestMapping(value = "editBook")
    public String editBook(Book book,Model model) throws Exception {
        
        bookService.updateBook(book);
        model.addAttribute("code", "success");
        model.addAttribute("msg", "修改成功");
        
        return "backstage/msg";
    }
    
    @RequestMapping(value = "delBook")
    public String delBook(String id, HttpServletRequest request, Model model) throws Exception {
        Book book = bookService.findBookById(id);
        String savePath = request.getServletContext().getRealPath("/");
        
        if(book.getImageW() != null) {
            File imageW = new File(savePath, book.getImageW());
            if(imageW != null) {
                imageW.delete();
            }
        }
        if(book.getImageB() != null){
            File imageB = new File(savePath, book.getImageB());
            if(imageB != null) {
                imageB.delete();
            }
        }
        
        bookService.delete(id);
        model.addAttribute("code", "success");
        model.addAttribute("btn", "del");
        model.addAttribute("msg", "删除成功");
        return "backstage/msg";
    }
    
    @RequestMapping(value ="loadBook")
    public String loadBook(String bookId, Model model) throws Exception {
        
        Book book = bookService.findBookById(bookId);
        List<Category> parents = categoryService.findFirstCategory();
        
        Category category = categoryService.findCategoryById(book.getCategoryId());
        
        List<Category> children = categoryService.findChildrenByParent(category.getParentId());
        
        model.addAttribute("book", book);
        model.addAttribute("category", category);
        model.addAttribute("parents", parents);
        model.addAttribute("children", children);
        
        return "backstage/admin/book/detail";
        
        
    }
    
    /** 
    * @Title: findBookByConditionAdmin 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param condition
    * @param value
    * @param model
    * @param request
    * @param pageCode
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value="findBookByConditionAdmin")
    public String findBookByConditionAdmin(String condition, String value, Model model, HttpServletRequest request,
            @RequestParam(value="pageCode", defaultValue = "1") int pageCode) throws Exception {

        PageBean<Book> pageBean = bookService.findBookByCondition(condition, value, pageCode);
        
        List<Category> parents = categoryService.findAllCategory();
              
        pageBean.setUrl(getUrl(request));        
    
        model.addAttribute("pageBean", pageBean);
        
        model.addAttribute("parents", parents);
        
        model.addAttribute("value", value);
        
        return "backstage/admin/book/list";
    }
    
    /** 
    * @Title: getUrl 
    * @Description: 获取请求url
    * @param request
    * @return
    */ 
    
    private String getUrl(HttpServletRequest request) {
        String url = request.getRequestURI() + "?" + request.getQueryString();
       
        int index = url.lastIndexOf("&pageCode=");
        if(index != -1) {
            url = url.substring(0, index);
        }
        return url;
    }
    
  
    /** 
    * @Title: findBookByCombinationAdmin 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param name
    * @param author
    * @param press
    * @param model
    * @param request
    * @param pageCode
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value="findBookByCombinationAdmin")
    public String findBookByCombinationAdmin(String value, String name, String author, String press, Model model, HttpServletRequest request,
            @RequestParam(value="pageCode", defaultValue = "1") int pageCode) throws Exception {
        
        PageBean<Book> pageBean = bookService.findBookByCombination(name, author, press, pageCode);
        
        List<Category> parents = categoryService.findAllCategory();
        
        pageBean.setUrl(getUrl(request));   
        
        model.addAttribute("pageBean", pageBean);
        
        model.addAttribute("parents", parents);
        
        model.addAttribute("value", value);
        
        return "backstage/admin/book/list";
    }
 
    /** 
    * @Title: findBookByIdAdmin 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param bookId
    * @param model
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value="findBookByIdAdmin")
    public String findBookByIdAdmin(String bookId, Model model) throws Exception {
        
        Book book = bookService.findBookById(bookId);
        
        model.addAttribute("book", book);
        
        return "backstage/admin/book/detail";
    }

    @RequestMapping(value ="findCategoryAllAdmin", method=RequestMethod.POST)
    public @ResponseBody List<Category> findCategoryAllAdmin() throws Exception {
        List<Category> categoryList = categoryService.findAllCategory();      
        return categoryList;
    }

}
