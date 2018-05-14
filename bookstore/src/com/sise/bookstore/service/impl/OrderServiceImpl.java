/**   
* @Project:	bookstore
* @Title: OrderServiceImpl.java
* @Package com.sise.bookstore.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月10日 上午9:43:28
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sise.bookstore.mapper.custom.CartItemMapperCustom;
import com.sise.bookstore.mapper.custom.OrderItemMapperCustom;
import com.sise.bookstore.mapper.custom.OrderMapperCustom;
import com.sise.bookstore.model.entity.Order;
import com.sise.bookstore.model.entity.OrderItem;
import com.sise.bookstore.model.result.CartItemCustom;
import com.sise.bookstore.model.result.OrderCustom;
import com.sise.bookstore.pager.PageBean;
import com.sise.bookstore.service.OrderService;
import com.sise.bookstore.util.ResourcesUtil;
import com.sise.bookstore.util.mail.CommonUtils;


/**
 * @ClassName: OrderServiceImpl
 * @Description: 订单业务实现类
 * @author: zhiguo.lin
 * @date 2016年11月10日 上午9:43:28
 * 
 */

@Service
public class OrderServiceImpl implements OrderService {
    
    @Resource
    private OrderMapperCustom orderMapperCustom;
    
    @Resource
    private CartItemMapperCustom cartItemMapperCustom;
    
    @Resource
    private OrderItemMapperCustom orderItemMapperCustom;

    /* (非 Javadoc) 
    * <p>Title: findOrderByUser</p> 
    * <p>Description: </p> 
    * @param userId
    * @return 
    * @see com.sise.bookstore.service.OrderService#findOrderByUser(java.lang.String) 
    */ 
    
    
    @Override
    public PageBean<Order> findOrderByUser(String userId, int pageCode) throws Exception {
        
        int pageSize =  Integer.parseInt(ResourcesUtil.getValue("pager", "pageSize"));
        
        //获取每页的数据
        List<Order> orderList = orderMapperCustom.selectOrderByUser(userId, (pageCode - 1) * pageSize, pageSize);
        //获取总记录数
        int totalRecord = orderMapperCustom.selectTotalRecord(userId);
        
        PageBean<Order> pageBean = new PageBean<Order>();
        
        pageBean.setPageCode(pageCode);
        
        pageBean.setPageSize(pageSize);
        
        pageBean.setRecords(orderList);
        
        pageBean.setTotalRecord(totalRecord);
        
        return pageBean;
    }

    /* (非 Javadoc) 
    * <p>Title: createOrder</p> 
    * <p>Description: </p> 
    * @param cartItemIds
    * @param address
    * @throws Exception 
    * @see com.sise.bookstore.service.OrderService#createOrder(java.lang.String[], java.lang.String) 
    */ 
    
    
    @Override
    public Order createOrder(String[] cartItemIds, String address) throws Exception {
        
        /*
         * 1. 获取所有购物车条目
         */
        List<CartItemCustom> cartItemList = cartItemMapperCustom.loadCartItems(cartItemIds);
        /*
         * 2.创建订单
         */
        Order order = new Order();
        
        order.setId(CommonUtils.uuid());
        
        order.setTime(String.format("%tF %<tT", new Date()));
        
        order.setStatus(1);
        
        order.setTotal(getTotal(cartItemList));
        
        order.setAddress(address);
        
        order.setUserId(ResourcesUtil.getCurrentUserId());
        
        orderMapperCustom.insertOrder(order);
        
        /*
         * 3. 创建List<OrderItem>
         * 一个CartItem对应一个OrderItem
         */
        List<OrderItem> list = new ArrayList<OrderItem>();
        for(CartItemCustom cartItem : cartItemList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(CommonUtils.uuid());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setSubtotal(new BigDecimal(cartItem.getSubtotal()));
            orderItem.setBookId(cartItem.getBook().getId());
            orderItem.setBookName(cartItem.getBook().getName());
            orderItem.setCurrPrice(cartItem.getBook().getCurrPrice());
            orderItem.setImageB(cartItem.getBook().getImageB());
            orderItem.setOrderId(order.getId());
            list.add(orderItem);
        }
        
        orderItemMapperCustom.insertBatch(list);
        
        cartItemMapperCustom.batchDelete(cartItemIds);
        
        return order;
      
        
       
    }

    /** 
    * @Title: getTotal 
    * @Description: 计算总价
    * @param cartItemList
    */ 
    
    
    private  BigDecimal getTotal(List<CartItemCustom> cartItemList) {
        BigDecimal total = new BigDecimal("0");
        for(CartItemCustom cartItem : cartItemList) {
            total = total.add(new BigDecimal(cartItem.getSubtotal() + ""));
        }
        
        return total;
    }

    /* (非 Javadoc) 
    * <p>Title: findOrderById</p> 
    * <p>Description: </p> 
    * @param orderId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.OrderService#findOrderById(java.lang.String) 
    */ 
    
    
    @Override
    public OrderCustom findOrderById(String orderId) throws Exception {
        
        OrderCustom order = orderMapperCustom.selectOrderById(orderId);
        
        return order;
    }

    /* (非 Javadoc) 
    * <p>Title: findStatus</p> 
    * <p>Description: </p> 
    * @param orderId
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.OrderService#findStatus(java.lang.String) 
    */ 
    
    
    @Override
    public int findStatus(String orderId) throws Exception {
        return orderMapperCustom.selectStatus(orderId);
    }

    /* (非 Javadoc) 
    * <p>Title: updateStatus</p> 
    * <p>Description: </p> 
    * @param orderId
    * @throws Exception 
    * @see com.sise.bookstore.service.OrderService#updateStatus(java.lang.String) 
    */ 
    
    
    @Override
    public void updateStatus(String orderId, int status) throws Exception {
        
        orderMapperCustom.updateStatus(orderId,status);
    }

    /* (非 Javadoc) 
    * <p>Title: findAll</p> 
    * <p>Description: </p> 
    * @param pageCode
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.OrderService#findAll(int) 
    */ 
    
    
    @Override
    public PageBean<Order> findAll(int pageCode) throws Exception {
        
        int pageSize = Integer.parseInt(ResourcesUtil.getValue("pager", "pageSize"));
        
        List<Order> orderList = orderMapperCustom.selectAll((pageCode -1) * pageSize,pageSize);
        
        int totalRecord = orderMapperCustom.selectAllRecord();
        
        PageBean<Order> pageBean = new PageBean<Order>();
        
        pageBean.setPageCode(pageCode);
        
        pageBean.setPageSize(pageSize);
        
        pageBean.setRecords(orderList);
        
        pageBean.setTotalRecord(totalRecord);
        
        return pageBean;
    }

    /* (非 Javadoc) 
    * <p>Title: findOrderByStatus</p> 
    * <p>Description: </p> 
    * @param status
    * @return
    * @throws Exception 
    * @see com.sise.bookstore.service.OrderService#findOrderByStatus(int) 
    */ 
    
    
    @Override
    public PageBean<Order> findOrderByStatus(int status, int pageCode) throws Exception {
        
        int pageSize = Integer.parseInt(ResourcesUtil.getValue("pager", "pageSize"));
        
        List<Order> orderList = orderMapperCustom.selectOrderByStatus(status,(pageCode -1) * pageSize,pageSize);
        
        int totalRecord = orderMapperCustom.selectTotalRecordByStatus(status);
        
        PageBean<Order> pageBean = new PageBean<Order>();
        
        pageBean.setPageCode(pageCode);
        pageBean.setPageSize(pageSize);
        pageBean.setRecords(orderList);
        pageBean.setTotalRecord(totalRecord);
        
        return pageBean;
    }


}
