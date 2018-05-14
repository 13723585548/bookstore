/**   
* @Project:	bookstore
* @Title: CartItemMapperCustom.java
* @Package com.sise.bookstore.mapper.custom
* @Description: 
* @author: zhiguo.lin   
* @date 2016年10月30日 下午4:01:19
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sise.bookstore.model.result.CartItemCustom;



/**
 * @ClassName: CartItemMapperCustom
 * @Description: 购物车条款操作接口
 * @author: zhiguo.lin
 * @date 2016年10月30日 下午4:01:19
 * 
 */

public interface CartItemMapperCustom {
    
  /** 
* @Title: selectCartItemByUser 
* @Description: 根据用户查询购物车条款
* @return
*/ 

public List<CartItemCustom> selectCartItemByUser(@Param("userId") String userId);


/** 
* @Title: selectCartItemByPrimaryKey 
* @Description: 根据主键查询购物车条款
* @param cartItemId
* @return
*/ 

public CartItemCustom selectCartItemByPrimaryKey(@Param("cartItemId") String cartItemId);
  

/** 
* @Title: batchDelete 
* @Description: 批量删除
* @param cartItemIds
*/ 

public void batchDelete(@Param("cartItemIds") String[] cartItemIds);

/** 
* @Title: loadCartItems 
* @Description: 加载购物车条款
* @param cartItemIds
* @return
*/ 

public List<CartItemCustom> loadCartItems(@Param("cartItemIds") String[] cartItemIds);
  
}
