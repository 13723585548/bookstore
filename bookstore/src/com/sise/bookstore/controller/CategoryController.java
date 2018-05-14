/**   
* @Project:	bookstore
* @Title: CategoryController.java
* @Package com.sise.bookstore.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月30日 上午11:14:09
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sise.bookstore.model.entity.Category;
import com.sise.bookstore.service.CategoryService;


/**
 * @ClassName: CategoryController
 * @Description: 用于做分类控制
 * @author: zhiguo.lin
 * @date 2016年10月30日 上午11:14:09
 * 
 */

@Controller
public class CategoryController {
    
    @Resource
    private CategoryService categoryService;
    
    /** 
    * @Title: findAllCategory 
    * @Description: 查询所有分类
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "findAllCategory")
    public String findAllCategory(Model model) throws Exception {
        List<Category> categoryList = categoryService.findAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "left";
    }
    
}
