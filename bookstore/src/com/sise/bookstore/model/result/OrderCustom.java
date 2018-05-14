/**   
* @Project:	bookstore
* @Title: OrderCustom.java
* @Package com.sise.bookstore.model.result
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月11日 上午10:35:48
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.model.result;

import java.util.List;

import com.sise.bookstore.model.entity.OrderItem;
import com.sise.bookstore.model.entity.User;


/**
 * @ClassName: OrderCustom
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月11日 上午10:35:48
 * 
 */

public class OrderCustom {

    private String id;//主键
    
    private String time;//下单时间
    
    private double total;//总计
    
    private int status;//订单状态：1未付款, 2已付款但未发货, 3已发货未确认收货, 4确认收货了交易成功, 5已取消(只有未付款才能取消)
   
    private String address;//收货地址
    
    private User owner;//订单的所有者
    
    private List<OrderItem> orderItemList;//订单项

    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    
    public String getTime() {
        return time;
    }

    
    public void setTime(String time) {
        this.time = time;
    }

    
    public double getTotal() {
        return total;
    }

    
    public void setTotal(double total) {
        this.total = total;
    }

    
    public int getStatus() {
        return status;
    }

    
    public void setStatus(int status) {
        this.status = status;
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address;
    }

    
    public User getOwner() {
        return owner;
    }

    
    public void setOwner(User owner) {
        this.owner = owner;
    }


    
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }


    
    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
}
