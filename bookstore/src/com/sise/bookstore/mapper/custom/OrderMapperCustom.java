/**   
* @Project:	bookstore
* @Title: OrderMapperCustom.java
* @Package com.sise.bookstore.mapper.custom
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月11日 上午9:38:12
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sise.bookstore.model.entity.Order;
import com.sise.bookstore.model.result.OrderCustom;


/**
 * @ClassName: OrderMapperCustom
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月11日 上午9:38:12
 * 
 */

public interface OrderMapperCustom {

    /** 
    * @Title: selectOrderByUser 
    * @Description: 根据用户查询订单
    * @param userId
    * @return
    */ 
    
    public List<Order> selectOrderByUser(@Param("userId") String userId, @Param("pageCode") int pageCode,
            @Param("pageSize") int pageSize);
    
    /** 
    * @Title: selectTotalRecord 
    * @Description: 查询用户订单总记录数
    * @param userId
    * @return
    */ 
    
    public int selectTotalRecord(@Param("userId") String userId);
    
    /** 
    * @Title: insert 
    * @Description: 插入
    * @param order
    */ 
    
    public void insertOrder(@Param("order") Order order);
    
    /** 
    * @Title: selectOrderById 
    * @Description: 查询订单详情
    * @param orderId
    * @return
    */ 
    
    public OrderCustom selectOrderById(@Param("orderId") String orderId);
    
    /** 
    * @Title: selectStatus 
    * @Description: 查询订单状态 
    * @param orderId
    * @return
    */ 
    
    public int selectStatus(@Param("orderId") String orderId);

   
    /** 
    * @Title: updateStatus 
    * @Description: 更新订单状态
    * @param orderId
    * @param status
    */ 
    
    public void updateStatus(@Param("orderId") String orderId, @Param("status") int status);

    /** 
    * @Title: selectAll 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param i
    * @param pageSize
    * @return
    */ 
    
    
    public List<Order> selectAll(@Param("pageCode") int pageCode, @Param("pageSize") int pageSize);

    /** 
    * @Title: selectTotalRecord 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @return
    */ 
    
    
    public int selectAllRecord();

    /** 
    * @Title: selectOrderByStatus 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param status
     * @return 
    */ 
    
    
    public List<Order> selectOrderByStatus(@Param("status") int status,@Param("pageCode") int pageCode, @Param("pageSize") int pageSize);

    /** 
    * @Title: selectTotalRecordByStatus 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param status
    * @return
    */ 
    
    
    public int selectTotalRecordByStatus(@Param("status") int status); 
    
}
