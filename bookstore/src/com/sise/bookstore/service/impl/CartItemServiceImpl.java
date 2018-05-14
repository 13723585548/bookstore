/**   
* @Project:	bookstore
* @Title: CartItemServiceImpl.java
* @Package com.sise.bookstore.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月3日 上午11:51:53
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sise.bookstore.mapper.CartItemMapper;
import com.sise.bookstore.mapper.custom.CartItemMapperCustom;
import com.sise.bookstore.model.entity.CartItem;
import com.sise.bookstore.model.entity.CartItemExample;
import com.sise.bookstore.model.entity.CartItemExample.Criteria;
import com.sise.bookstore.model.result.CartItemCustom;
import com.sise.bookstore.service.CartItemService;
import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: CartItemServiceImpl
 * @Description: 购物车服务类实现
 * @author: zhiguo.lin
 * @date 2016年11月3日 上午11:51:53
 * 
 */

@Service
public class CartItemServiceImpl implements CartItemService {
    
    @Resource
    private CartItemMapperCustom cartItemMapperCustom;
    
    @Resource
    private CartItemMapper cartItemMapper;

  

    /* (非 Javadoc) 
    * <p>Title: findCartItemByUser</p> 
    * <p>Description: </p> 
    * @param userId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CartItemService#findCartItemByUser(java.lang.String) 
    */ 
    
    @Override
    public List<CartItemCustom> findCartItemByUser(String userId) throws Exception {
        
        List<CartItemCustom> cartItemList = cartItemMapperCustom.selectCartItemByUser(userId);
        
        return cartItemList;
    }



    /* (非 Javadoc) 
    * <p>Title: addCartItem</p> 
    * <p>Description: </p> 
    * @param cartItem
    * @throws Exception 
    * @see com.sise.bookstore.service.CartItemService#addCartItem(com.sise.bookstore.model.entity.CartItem) 
    */ 
    
    
    @Override
    public void addCartItem(CartItem cartItem) throws Exception {
        
        
        CartItemExample cartItemExample = new CartItemExample();
        Criteria criteria = cartItemExample.createCriteria();
        criteria.andUserIdEqualTo(cartItem.getUserId());
        criteria.andBookIdEqualTo(cartItem.getBookId());
        List<CartItem> _cartItem =  cartItemMapper.selectByExample(cartItemExample);
        
        if (_cartItem == null || _cartItem.size() == 0) {
            cartItem.setId(CommonUtils.uuid());
            cartItemMapper.insert(cartItem);
        } else {
            int quantity = cartItem.getQuantity() + _cartItem.get(0).getQuantity();
            this.updateQuantity(_cartItem.get(0).getId(), quantity);
        }
        
    }



    /* (非 Javadoc) 
    * <p>Title: updateQuantity</p> 
    * <p>Description: </p> 
    * @param cartItemId
    * @param quantity
    * @throws Exception 
    * @see com.sise.bookstore.service.CartItemService#updateQuantity(java.lang.String, int) 
    */ 
    
    
    @Override
    public CartItemCustom updateQuantity(String cartItemId, int quantity) throws Exception {
        
        CartItem cartItem = cartItemMapper.selectByPrimaryKey(cartItemId);
        cartItem.setQuantity(quantity);
        cartItemMapper.updateByPrimaryKey(cartItem);
        
        return cartItemMapperCustom.selectCartItemByPrimaryKey(cartItemId);
        
    }



    /* (非 Javadoc) 
    * <p>Title: batchDelete</p> 
    * <p>Description: </p> 
    * @param cartItemIds
    * @throws Exception 
    * @see com.sise.bookstore.service.CartItemService#batchDelete(java.lang.String[]) 
    */ 
    
    
    @Override
    public void batchDelete(String[] cartItemIds) throws Exception {
        cartItemMapperCustom.batchDelete(cartItemIds);
    }



    /* (非 Javadoc) 
    * <p>Title: loadCartItems</p> 
    * <p>Description: </p> 
    * @param cartItemIds
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.CartItemService#loadCartItems(java.lang.String[]) 
    */ 
    
    
    @Override
    public List<CartItemCustom> loadCartItems(String[] cartItemIds) throws Exception {
        return cartItemMapperCustom.loadCartItems(cartItemIds);
    }

}
