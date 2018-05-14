/**   
* @Project:	bookstore
* @Title: AjaxJson.java
* @Package com.sise.bookstore.message
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月5日 下午5:18:24
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.message;

import java.util.Map;


/**
 * @ClassName: AjaxJson
 * @Description: 封装json数据
 * @author: zhiguo.lin
 * @date 2016年11月5日 下午5:18:24
 * 
 */

public class AjaxJson {

    private boolean success = true;// 是否成功
    
    private String msg = "操作成功";// 提示信息
    
    private Object obj = null;// 其他信息
    
    private Map<String, Object> attributes;// 其他参数

    
    public boolean isSuccess() {
        return success;
    }

    
    public void setSuccess(boolean success) {
        this.success = success;
    }

    
    public String getMsg() {
        return msg;
    }

    
    public void setMsg(String msg) {
        this.msg = msg;
    }

    
    public Object getObj() {
        return obj;
    }

    
    public void setObj(Object obj) {
        this.obj = obj;
    }

    
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    
    
    
}
