/**   
* @Project:	springmvc_mybatis
* @Title: DateConverter.java
* @Package com.sise.ssm.converter
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年9月16日 上午9:52:53
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * @ClassName: DateConverter
 * @Description: 日期转换器
 * @author: zhiguo.lin
 * @date 2016年9月16日 上午9:52:53
 * 
 */

public class DateConverter implements Converter<String,Date> {

    /* (非 Javadoc) 
    * <p>Title: convert</p> 
    * <p>Description: </p> 
    * @param arg0
    * @return 
    * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object) 
    */ 
    
    
    @Override
    public Date convert(String source) {
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            return null;
        }

    }

}
