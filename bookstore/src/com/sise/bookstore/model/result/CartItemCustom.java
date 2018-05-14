/**   
* @Project:	bookstore
* @Title: CartItemCustom.java
* @Package com.sise.bookstore.model.result
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月3日 上午10:48:40
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.model.result;

import java.math.BigDecimal;

import com.sise.bookstore.model.entity.Book;
import com.sise.bookstore.model.entity.User;


/**
 * @ClassName: CartItemCustom
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月3日 上午10:48:40
 * 
 */

public class CartItemCustom {

    private String id; // 主键
    
    private Integer quantity; // 数量
    
    private Book book; // 条目对应的图书
    
    private User user; // 所属用户
    
    // 添加小计方法
    public double getSubtotal() {
        /*
         * 使用BigDecimal不会有误差
         * 要求必须使用String类型构造器
         */
        BigDecimal b1 = new BigDecimal(book.getCurrPrice() + "");
        BigDecimal b2 = new BigDecimal(quantity + "");
        BigDecimal b3 = b1.multiply(b2);
        return b3.doubleValue();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    public Book getBook() {
        return book;
    }

    
    public void setBook(Book book) {
        this.book = book;
    }

    
    public User getUser() {
        return user;
    }

    
    public void setUser(User user) {
        this.user = user;
    }
    
}
