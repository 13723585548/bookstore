/**   
* @Project:	bookstore
* @Title: CategoryController.java
* @Package com.sise.bookstore.admin.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月16日 上午11:30:57
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sise.bookstore.model.entity.Category;
import com.sise.bookstore.service.BookService;
import com.sise.bookstore.service.CategoryService;


/**
 * @ClassName: CategoryController
 * @Description: 查找所有分类
 * @author: zhiguo.lin
 * @date 2016年11月16日 上午11:30:57
 * 
 */
@RequestMapping("/admin")
@Controller
public class AdminCategoryController {
    
    @Resource
    private BookService bookService;
    
    @Resource
    private CategoryService categoryService;
    
    @RequestMapping(value = "getAllCategory")
    public String getAllCategory(Model model) throws Exception {
        
        List<Category> categoryList = categoryService.findAllCategory();
        
        model.addAttribute("categoryList", categoryList);
        
        return "backstage/admin/category/list";
    }
    
    /** 
    * @Title: addFirstCategory 
    * @Description: 添加分类
    * @param categoryForm
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "addCategory", method = RequestMethod.POST)
    public String addCategory(Category categoryForm) throws Exception {
        categoryService.addCategory(categoryForm);
        return "redirect:/admin/getAllCategory.action";
        
    }
    
    /** 
    * @Title: addSecondPrepare 
    * @Description: 跳转到添加二级分类页面
    * @param parentId
    * @param model
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "addSecondPrepare")
    public String addSecondPrepare(String parentId, Model model) throws Exception {
        
        List<Category> firstCategoryList = categoryService.findFirstCategory();
        
        model.addAttribute("parentId", parentId);
        model.addAttribute("firstCategoryList", firstCategoryList);
        
        return "backstage/admin/category/addSecond";
    }
    
    @RequestMapping(value = "editPrepare")
    public String editPrepare(String categoryId,Model model) throws Exception {
        
        Category category = categoryService.findCategoryById(categoryId);
        
        model.addAttribute("category", category);
        
        return "backstage/admin/category/editFirst"; 
    }
    
    @RequestMapping(value = "editSecondPrepare")
    public String editSecondPrepare(String categoryId, Model model) throws Exception {
        
        Category child = categoryService.findCategoryById(categoryId);
        
        List<Category> parents = categoryService.findAllCategory();
        
        model.addAttribute("parents", parents);
        
        model.addAttribute("child", child);
        
        return "backstage/admin/category/editSecond";
    }
    
    @RequestMapping(value = "editCategory", method = RequestMethod.POST)
    public String editCategory(@Param("category") Category category) throws Exception {
        categoryService.updateCategory(category);
        return "redirect:/admin/getAllCategory.action";
    }
    
    @RequestMapping(value = "deleteParent")
    public String deleteParent(String categoryId, Model model) throws Exception {
        
        int count = categoryService.findChildrenCountByParent(categoryId);
        
        if(count > 0) {
            model.addAttribute("code", "error");
            model.addAttribute("msg", "该分类下还有子分类，不能删除");
            return "backstage/admin/msg";
        } else {
            categoryService.deleteCategory(categoryId);
        }
        
        return "redirect:/admin/getAllCategory.action";
    }
    
    @RequestMapping(value = "deleteChild")
    public String deleteChild(String categoryId, Model model) throws Exception {
        
        int count = bookService.findBookCountByCategory(categoryId);
        
        if (count > 0) { 
            model.addAttribute("code", "error");
            model.addAttribute("msg", "该分类下还存在图书，不能删除！");
            return "backstage/admin/msg";
        } else {
            categoryService.deleteCategory(categoryId);
        }
        return "redirect:/admin/getAllCategory.action";
    }

}
