/**   
* @Project:	bookstore
* @Title: AdminOrderController.java
* @Package com.sise.bookstore.controller.admin
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月22日 下午12:29:57
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sise.bookstore.model.entity.Order;
import com.sise.bookstore.model.result.OrderCustom;
import com.sise.bookstore.pager.PageBean;
import com.sise.bookstore.service.OrderService;


/**
 * @ClassName: AdminOrderController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: zhiguo.lin
 * @date 2016年11月22日 下午12:29:57
 * 
 */
@RequestMapping("/admin")
@Controller
public class AdminOrderController {
    
    @Resource
    private OrderService orderService;
    
    @RequestMapping(value = "findAllOrder")
    public String findAllOrder(Model model, HttpServletRequest request,
            @RequestParam(value = "pageCode", defaultValue = "1") int pageCode) throws Exception {
        
        PageBean<Order> pageBean = orderService.findAll(pageCode);
        
        pageBean.setUrl(getUrl(request));
        
        model.addAttribute("pageBean", pageBean);
               
        return "backstage/admin/order/list";
        
    }
    
    /** 
     * @Title: getUrl 
     * @Description: 获取请求url
     * @param request
     * @return
     */ 
     
     private String getUrl(HttpServletRequest request) {
         String url = request.getRequestURI() + "?" + request.getQueryString();
        
         int index = url.lastIndexOf("&pageCode=");
         if(index != -1) {
             url = url.substring(0, index);
         }
         return url;
     }
     
     @RequestMapping(value = "findOrderByIdAdmin")
     public String findOrderByIdAdmin(String orderId, String btn, Model model) throws Exception {
         
         OrderCustom order = orderService.findOrderById(orderId);
         
         model.addAttribute("order", order);
         
         model.addAttribute("btn", btn);
         
         return "backstage/admin/order/detail";
     }
     
     @RequestMapping(value = "deliver")
     public String deliver(String orderId, Model model) throws Exception {
         
         int status = orderService.findStatus(orderId);
         
         if (status !=2) {
             model.addAttribute("code", "error");
             model.addAttribute("msg","状态不对，不能发货！");
             return "backstage/admin/msg";
         }
         
         orderService.updateStatus(orderId, 3);
         model.addAttribute("code", "success");
         model.addAttribute("msg", "您的订单已发货，请查看物流，马上确认吧！");
         return "backstage/admin/msg";
     }
     
     /** 
      * @Title: cancel 
      * @Description: 取消订单
      * @param orderId
      * @param model
      * @return
      * @throws Exception
      */ 
      
      @RequestMapping(value = "cancelAdmin")
      public String cancelAdmin(String orderId,Model model) throws Exception {
          
          /*
           * 1. 校验订单状态
           */
          int status = orderService.findStatus(orderId);
          if (status != 1) {
              model.addAttribute("code", "error");
              model.addAttribute("msg", "状态不对,不能取消");
              return "msg";
          }
          
          orderService.updateStatus(orderId, 5);
          model.addAttribute("code", "success");
          model.addAttribute("msg", "您的订单已取消！");
          return "msg";
      }
      
      @RequestMapping(value = "findOrderByStatus")
      public String findOrderByStatus(Model model, HttpServletRequest request, int status,
              @RequestParam(value = "pageCode", defaultValue = "1") int pageCode) throws Exception {
          PageBean<Order> pageBean = orderService.findOrderByStatus(status,pageCode);
          pageBean.setUrl(getUrl(request));
          model.addAttribute("pageBean", pageBean);
          return "backstage/admin/order/list";
      }

}
