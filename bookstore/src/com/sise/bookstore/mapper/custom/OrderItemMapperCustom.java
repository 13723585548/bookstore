/**   
* @Project:	bookstore
* @Title: OrderItemCustom.java
* @Package com.sise.bookstore.mapper.custom
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月11日 上午11:29:27
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sise.bookstore.model.entity.Order;
import com.sise.bookstore.model.entity.OrderItem;


/**
 * @ClassName: OrderItemCustom
 * @Description: 自定义订单条目持久类
 * @author: zhiguo.lin
 * @date 2016年11月11日 上午11:29:27
 * 
 */

public interface OrderItemMapperCustom {
    
    /** 
    * @Title: selectOrderItemByOrder 
    * @Description: 查询订单条目
    * @param orderId
    * @return
    */ 
    
    public List<Order> selectOrderItemByOrder(@Param("orderId") String orderId);
    
    /** 
    * @Title: insertBatch 
    * @Description: 批量插入
    * @param list
    */ 
    
    public void insertBatch(@Param("list") List<OrderItem> list);

}
