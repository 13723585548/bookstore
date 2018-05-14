/**   
* @Project:	bookstore
* @Title: OrderController.java
* @Package com.sise.bookstore.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月10日 上午9:43:57
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sise.bookstore.model.entity.Order;
import com.sise.bookstore.model.result.OrderCustom;
import com.sise.bookstore.pager.PageBean;
import com.sise.bookstore.service.OrderService;
import com.sise.bookstore.util.PaymentUtil;
import com.sise.bookstore.util.ResourcesUtil;


/**
 * @ClassName: OrderController
 * @Description: 订单控制类
 * @author: zhiguo.lin
 * @date 2016年11月10日 上午9:43:57
 * 
 */

@Controller
public class OrderController {
    
    @Resource
    private OrderService orderService;

    
    /** 
    * @Title: myOrder 
    * @Description: 加载我的订单
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "myOrder")
    public String myOrder(Model model, HttpServletRequest request,
            @RequestParam(value = "pageCode", defaultValue = "1") int pageCode) throws Exception {
        
        String userId = ResourcesUtil.getCurrentUserId();
        
        PageBean<Order> pageBean = orderService.findOrderByUser(userId, pageCode);
        
        pageBean.setUrl(ResourcesUtil.getUrl(request));
        
        model.addAttribute("pageBean", pageBean);
        
        return "order/list";
    }
    
    /** 
    * @Title: createOrder 
    * @Description: 创建订单
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "createOrder", method = RequestMethod.POST)
    public String createOrder(String[] cartItemIds, String address, Model model) throws Exception {
        
        Order order = orderService.createOrder(cartItemIds, address);
        
        model.addAttribute("order", order);
        
        return "order/success";
    }
    
    /** 
    * @Title: findOrderById 
    * @Description: 查询订单详情
    * @param orderId
    * @param btn
    * @param model
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "findOrderById")
    public String findOrderById(String orderId, String btn, Model model) throws Exception {
        
        OrderCustom order = orderService.findOrderById(orderId);
        
        model.addAttribute("order", order);
        
        model.addAttribute("btn", btn);
        
        return "order/detail";
    }
    
   
    
    /** 
    * @Title: cancel 
    * @Description: 取消订单
    * @param orderId
    * @param model
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "cancel")
    public String cancel(String orderId,Model model) throws Exception {
        
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
    
    /** 
    * @Title: confirm 
    * @Description: 确认收货
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "confirm")
    public String confirm(String orderId, Model model) throws Exception {
        
        int status = orderService.findStatus(orderId);
        
        if (status != 3) {
            model.addAttribute("code", "error");
            model.addAttribute("msg", "状态不对,不能确认收货");
            return "msg";
        }
        orderService.updateStatus(orderId, 4);
        model.addAttribute("code", "success");
        model.addAttribute("msg", "恭喜，交易成功！");
        
        return "msg";
    }
    
    /** 
    * @Title: paymentPrepare 
    * @Description: 支付准备
    * @param orderId
    * @param model
    * @return
    * @throws Exception
    */ 
    
    @RequestMapping(value = "paymentPrepare")
    public String paymentPrepare(String orderId, Model model) throws Exception {
        
       OrderCustom order = orderService.findOrderById(orderId);
       
       model.addAttribute("order", order);
        
        return "order/pay";
    }
    
    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public String payment(String orderId, String yh,HttpServletResponse response) throws Exception {
        
        String p0_Cmd = "Buy";//业务类型，固定值Buy
        String p1_MerId = ResourcesUtil.getValue("payment", "p1_MerId");
        String p2_Order = orderId;//订单编码
        String p3_Amt = "0.01";//支付金额
        String p4_Cur = "CNY";//交易币种，固定值CNY
        String p5_Pid = "";//商品名称
        String p6_Pcat = "";//商品种类
        String p7_Pdesc = "";//商品描述
        String p8_Url = ResourcesUtil.getValue("payment", "p8_Url");//在支付成功后，易宝会访问这个地址。
        String p9_SAF = "";//送货地址
        String pa_MP = "";//扩展信息
        String pd_FrpId = yh;//支付通道
        String pr_NeedResponse = "1";//应答机制，固定值1
        
        /*
         * 2. 计算hmac
         * 需要13个参数
         * 需要keyValue
         * 需要加密算法
         */
        String keyValue = ResourcesUtil.getValue("payment", "keyValue");
        
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue);
        
        /*
         * 3. 重定向到易宝的支付网关
         */
        StringBuilder sb = new StringBuilder("https://www.yeepay.com/app-merchant-proxy/node");
        sb.append("?").append("p0_Cmd=").append(p0_Cmd);
        sb.append("&").append("p1_MerId=").append(p1_MerId);
        sb.append("&").append("p2_Order=").append(p2_Order);
        sb.append("&").append("p3_Amt=").append(p3_Amt);
        sb.append("&").append("p4_Cur=").append(p4_Cur);
        sb.append("&").append("p5_Pid=").append(p5_Pid);
        sb.append("&").append("p6_Pcat=").append(p6_Pcat);
        sb.append("&").append("p7_Pdesc=").append(p7_Pdesc);
        sb.append("&").append("p8_Url=").append(p8_Url);
        sb.append("&").append("p9_SAF=").append(p9_SAF);
        sb.append("&").append("pa_MP=").append(pa_MP);
        sb.append("&").append("pd_FrpId=").append(pd_FrpId);
        sb.append("&").append("pr_NeedResponse=").append(pr_NeedResponse);
        sb.append("&").append("hmac=").append(hmac);
        
        response.sendRedirect(sb.toString());
        
        return null;
    }
    
    @RequestMapping(value = "back")
    public String back(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        
        /*
         * 1. 获取12个参数
         */
        String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType =request.getParameter("r9_BType");
        String hmac = request.getParameter("hmac");
        
        /*
         * 2. 获取keyValue
         */
        String keyValue = ResourcesUtil.getValue("payment", "keyValue");
        
        boolean bool = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId,
                r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType,
                keyValue);
        
        if (!bool) {
            model.addAttribute("code", "error");
            model.addAttribute("msg", "无效的签名,支付失败");
            return "msg";
        }
        
        if (r1_Code.equals("1")) {
            orderService.updateStatus(r6_Order, 2);
            if(r9_BType.equals("1")) {
                model.addAttribute("code", "success");
                model.addAttribute("msg", "恭喜，支付成功！");
                return "msg";               
            } else if(r9_BType.equals("2")) {
                response.getWriter().print("success");
            }
        }
        return null;
    }

}
