/**   
* @Project:	bookstore
* @Title: CartItemController.java
* @Package com.sise.bookstore.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月3日 下午2:57:53
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sise.bookstore.message.AjaxJson;
import com.sise.bookstore.model.entity.CartItem;
import com.sise.bookstore.model.result.CartItemCustom;
import com.sise.bookstore.service.CartItemService;
import com.sise.bookstore.util.ResourcesUtil;
import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: CartItemController
 * @Description: 购物车控制类
 * @author: zhiguo.lin
 * @date 2016年11月3日 下午2:57:53
 * 
 */

@Controller
public class CartItemController {
    
    @Resource
    private CartItemService cartItemService;

    @RequestMapping("/findCartItemByUser")
    public String findCartItemByUser(Model model) throws Exception {
        
        String userId = ResourcesUtil.getCurrentUserId();
        
        List<CartItemCustom> cartItemList = cartItemService.findCartItemByUser(userId);
        
       model.addAttribute("cartItemList", cartItemList);      
       
        return "cart/list";
    }
    
    @RequestMapping(value = "/addCartItem", method = RequestMethod.POST)
    public String addCartItem(CartItem cartItem) throws Exception {
        
        String userId = ResourcesUtil.getCurrentUserId();
        
        cartItem.setUserId(userId);
        
        cartItem.setId(CommonUtils.uuid());
        
        cartItemService.addCartItem(cartItem);
        
        return "redirect:/findCartItemByUser.action";
    }
    
    @RequestMapping(value = "/updateQuantity", method = RequestMethod.POST)
    public @ResponseBody AjaxJson updateQuantity(String cartItemId, int quantity) throws Exception {
        
        CartItemCustom cartItem = cartItemService.updateQuantity(cartItemId, quantity);
        
        AjaxJson resObject = new AjaxJson();
        
        resObject.setObj(cartItem);
        
        return resObject;
    }


    @RequestMapping(value = "batchDeleteCartItem")
    public String batchDeleteCartItem(String[] cartItemIds) throws Exception {
        
        cartItemService.batchDelete(cartItemIds);
        
        return "redirect:/findCartItemByUser.action";
        
    }
    
    @RequestMapping(value = "loadCartItems")
    public String loadCartItems(String[] cartItemIds, String total, Model model) throws Exception {
        
        List<CartItemCustom> cartItemList = cartItemService.loadCartItems(cartItemIds);
        
        model.addAttribute("cartItemList", cartItemList);
        
        model.addAttribute("total", total);
        
        model.addAttribute("cartItemIds", cartItemIds);
        
        return "cart/showItem";
    }
    
    
}
