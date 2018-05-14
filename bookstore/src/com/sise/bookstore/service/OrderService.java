/**   
* @Project:	bookstore
* @Title: OrderService.java
* @Package com.sise.bookstore.service
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月10日 上午9:42:51
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service;

import com.sise.bookstore.model.entity.Order;
import com.sise.bookstore.model.result.OrderCustom;
import com.sise.bookstore.pager.PageBean;


/**
 * @ClassName: OrderService
 * @Description: 订单业务类
 * @author: zhiguo.lin
 * @date 2016年11月10日 上午9:42:51
 * 
 */

/**
* @ClassName: OrderService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author: zhiguo.lin
* @date 2016年11月14日 上午11:33:56
* 
*/

public interface OrderService {

 
    /** 
    * @Title: findOrderByUser 
    * @Description: 根据用户查询订单
    * @param userId
    * @return
    */ 
    
    public PageBean<Order> findOrderByUser(String userId, int pageCode) throws Exception;
    
    
    /** 
    * @Title: createOrder 
    * @Description: 创建订单
    * @throws Exception
    */ 
    
    public Order createOrder(String[] cartItemIds, String address) throws Exception;
    
    /** 
    * @Title: findOrderById 
    * @Description: 查询订单
    * @param orderId
    * @return
    * @throws Exception
    */ 
    
    public OrderCustom findOrderById(String orderId) throws Exception;
    
    /** 
    * @Title: findStatus 
    * @Description: 查询订单状态
    * @param orderId
    * @return
    * @throws Exception
    */ 
    
    public int findStatus(String orderId) throws Exception;


   
    /** 
    * @Title: updateStatus 
    * @Description: 更新订单状态
    * @param orderId
    * @param status
    * @throws Exception
    */ 
    
    public void updateStatus(String orderId, int status) throws Exception;


    /** 
    * @Title: findAll 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param pageCode
    * @return
    */ 
    
    
    public PageBean<Order> findAll(int pageCode) throws Exception;


    /** 
    * @Title: findOrderByStatus 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param status
    * @return
    */ 
    
    
    public PageBean<Order> findOrderByStatus(int status, int pageCode) throws Exception;
}
