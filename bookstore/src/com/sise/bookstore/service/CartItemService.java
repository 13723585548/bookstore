/**   
* @Project:	bookstore
* @Title: CartItemService.java
* @Package com.sise.bookstore.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月3日 上午11:49:53
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import java.util.List;

import com.sise.bookstore.model.entity.CartItem;
import com.sise.bookstore.model.result.CartItemCustom;


/**
 * @ClassName: CartItemService
 * @Description: 购物车服务类
 * @author: zhiguo.lin
 * @date 2016年11月3日 上午11:49:53
 * 
 */

public interface CartItemService {

    /** 
    * @Title: findCartItemByUser 
    * @Description: 根据用户查询购物车条款
    * @param userId
    * @return
    * @throws Exception
    */ 
    
    public List<CartItemCustom> findCartItemByUser(String userId) throws Exception;
    
    /** 
    * @Title: addCartItem 
    * @Description: 添加购物车款项
    * @param cartItem
    * @throws Exception
    */ 
    
    public void addCartItem(CartItem cartItem) throws Exception;
    
    /** 
    * @Title: updateQuantity 
    * @Description: 修改条款数量
    * @param cartItemId
    * @param quantity
    * @throws Exception
    */ 
    
    public CartItemCustom updateQuantity(String cartItemId, int quantity ) throws Exception;
    
    /** 
    * @Title: batchDelete 
    * @Description: 批量删除 
    * @param cartItemIds
    * @throws Exception
    */ 
    
    public void batchDelete(String[] cartItemIds) throws Exception;
    
    /** 
    * @Title: loadCartItems 
    * @Description: 加载购物车选中条款
    * @return
    * @throws Exception
    */ 
    
    public List<CartItemCustom> loadCartItems(String[] cartItemIds) throws Exception;
    
}
