/**   
* @Project:	bookstore
* @Title: PageBean.java
* @Package com.sise.bookstore.controller.model
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年10月30日 下午12:38:21
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.pager;

import java.util.List;


/**
 * @ClassName: PageBean
 * @Description: 封装分页数据
 * @author: zhiguo.lin
 * @param <T>
 * @date 2016年10月30日 下午12:38:21
 * 
 */

public class PageBean<T> {
    
    private int pageCode; //当前页码
    
    private int totalRecord;//总记录数
    
    private int pageSize;//每页记录数
    
    private String url;//请求路径和参数
    
    private List<T> records;//数据源
      
    public int getTotalPage() {
        int totalPage = totalRecord/pageSize;
        return totalRecord % pageSize == 0 ? totalPage : totalPage + 1;
    }

    public int getPageCode() {
        return pageCode;
    }

    
    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    
    public int getTotalRecord() {
        return totalRecord;
    }

    
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    
    public int getPageSize() {
        return pageSize;
    }

    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    
    public List<T> getRecords() {
        return records;
    }

    
    public void setRecords(List<T> records) {
        this.records = records;
    }

    
    public String getUrl() {
        return url;
    }

    
    public void setUrl(String url) {
        this.url = url;
    }
    
   /* public String getHrefFormer() {
        return hrefFormer;
    }

    
    public void setHrefFormer(String hrefFormer) {
        this.hrefFormer = hrefFormer;
    }

    
    public String getHrefLatter() {
        return hrefLatter;
    }

    
    public void setHrefLatter(String hrefLatter) {
        this.hrefLatter = hrefLatter;
    }*/

}
