/**   
* @Project:	bookstore
* @Title: Expression.java
* @Package com.sise.bookstore.pager
* @Description: TODO(用一句话描述该文件做什么)
* @author: zhiguo.lin   
* @date 2016年11月1日 上午11:17:13
* @CopyRight: CopyRight@2016
* @version V1.0   
*/


package com.sise.bookstore.pager;


/**
 * @ClassName: Expression
 * @Description: 用于构造表达式
 * @author: zhiguo.lin
 * @date 2016年11月1日 上午11:17:13
 * 
 */

public class Expression {

    private String name;
    
    private String operator;
    
    private String value;   
    
    /**
     * <p>Title: </p>
     * <p>Description: </p>
     */
     
     
     public Expression() {
         super();
     }
    
    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param name
     * @param operator
     * @param value
     */
     
     
     public Expression(String name, String operator, String value) {
         super();
         this.name = name;
         this.operator = operator;
         this.value = value;
     }
    
    

    public String getName() {
        return name;
    }   

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getOperator() {
        return operator;
    }

    
    public void setOperator(String operator) {
        this.operator = operator;
    }

    
    public String getValue() {
        return value;
    }

    
    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Expression [name=" + name + ", operator=" + operator + ", value=" + value + "]";
    }
    

}
