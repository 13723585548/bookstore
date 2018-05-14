package com.sise.bookstore.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCurrPriceIsNull() {
            addCriterion("currPrice is null");
            return (Criteria) this;
        }

        public Criteria andCurrPriceIsNotNull() {
            addCriterion("currPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCurrPriceEqualTo(BigDecimal value) {
            addCriterion("currPrice =", value, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceNotEqualTo(BigDecimal value) {
            addCriterion("currPrice <>", value, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceGreaterThan(BigDecimal value) {
            addCriterion("currPrice >", value, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("currPrice >=", value, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceLessThan(BigDecimal value) {
            addCriterion("currPrice <", value, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("currPrice <=", value, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceIn(List<BigDecimal> values) {
            addCriterion("currPrice in", values, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceNotIn(List<BigDecimal> values) {
            addCriterion("currPrice not in", values, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currPrice between", value1, value2, "currPrice");
            return (Criteria) this;
        }

        public Criteria andCurrPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("currPrice not between", value1, value2, "currPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andPressIsNull() {
            addCriterion("press is null");
            return (Criteria) this;
        }

        public Criteria andPressIsNotNull() {
            addCriterion("press is not null");
            return (Criteria) this;
        }

        public Criteria andPressEqualTo(String value) {
            addCriterion("press =", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotEqualTo(String value) {
            addCriterion("press <>", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThan(String value) {
            addCriterion("press >", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressGreaterThanOrEqualTo(String value) {
            addCriterion("press >=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThan(String value) {
            addCriterion("press <", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLessThanOrEqualTo(String value) {
            addCriterion("press <=", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressLike(String value) {
            addCriterion("press like", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotLike(String value) {
            addCriterion("press not like", value, "press");
            return (Criteria) this;
        }

        public Criteria andPressIn(List<String> values) {
            addCriterion("press in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotIn(List<String> values) {
            addCriterion("press not in", values, "press");
            return (Criteria) this;
        }

        public Criteria andPressBetween(String value1, String value2) {
            addCriterion("press between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPressNotBetween(String value1, String value2) {
            addCriterion("press not between", value1, value2, "press");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publishtime is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publishtime is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(String value) {
            addCriterion("publishtime =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(String value) {
            addCriterion("publishtime <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(String value) {
            addCriterion("publishtime >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("publishtime >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(String value) {
            addCriterion("publishtime <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(String value) {
            addCriterion("publishtime <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLike(String value) {
            addCriterion("publishtime like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotLike(String value) {
            addCriterion("publishtime not like", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<String> values) {
            addCriterion("publishtime in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<String> values) {
            addCriterion("publishtime not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(String value1, String value2) {
            addCriterion("publishtime between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(String value1, String value2) {
            addCriterion("publishtime not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andEditionIsNull() {
            addCriterion("edition is null");
            return (Criteria) this;
        }

        public Criteria andEditionIsNotNull() {
            addCriterion("edition is not null");
            return (Criteria) this;
        }

        public Criteria andEditionEqualTo(Integer value) {
            addCriterion("edition =", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotEqualTo(Integer value) {
            addCriterion("edition <>", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionGreaterThan(Integer value) {
            addCriterion("edition >", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("edition >=", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLessThan(Integer value) {
            addCriterion("edition <", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionLessThanOrEqualTo(Integer value) {
            addCriterion("edition <=", value, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionIn(List<Integer> values) {
            addCriterion("edition in", values, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotIn(List<Integer> values) {
            addCriterion("edition not in", values, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionBetween(Integer value1, Integer value2) {
            addCriterion("edition between", value1, value2, "edition");
            return (Criteria) this;
        }

        public Criteria andEditionNotBetween(Integer value1, Integer value2) {
            addCriterion("edition not between", value1, value2, "edition");
            return (Criteria) this;
        }

        public Criteria andPageNumIsNull() {
            addCriterion("pageNum is null");
            return (Criteria) this;
        }

        public Criteria andPageNumIsNotNull() {
            addCriterion("pageNum is not null");
            return (Criteria) this;
        }

        public Criteria andPageNumEqualTo(Integer value) {
            addCriterion("pageNum =", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotEqualTo(Integer value) {
            addCriterion("pageNum <>", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumGreaterThan(Integer value) {
            addCriterion("pageNum >", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pageNum >=", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumLessThan(Integer value) {
            addCriterion("pageNum <", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumLessThanOrEqualTo(Integer value) {
            addCriterion("pageNum <=", value, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumIn(List<Integer> values) {
            addCriterion("pageNum in", values, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotIn(List<Integer> values) {
            addCriterion("pageNum not in", values, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumBetween(Integer value1, Integer value2) {
            addCriterion("pageNum between", value1, value2, "pageNum");
            return (Criteria) this;
        }

        public Criteria andPageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pageNum not between", value1, value2, "pageNum");
            return (Criteria) this;
        }

        public Criteria andWordNumIsNull() {
            addCriterion("wordNum is null");
            return (Criteria) this;
        }

        public Criteria andWordNumIsNotNull() {
            addCriterion("wordNum is not null");
            return (Criteria) this;
        }

        public Criteria andWordNumEqualTo(Integer value) {
            addCriterion("wordNum =", value, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumNotEqualTo(Integer value) {
            addCriterion("wordNum <>", value, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumGreaterThan(Integer value) {
            addCriterion("wordNum >", value, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("wordNum >=", value, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumLessThan(Integer value) {
            addCriterion("wordNum <", value, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumLessThanOrEqualTo(Integer value) {
            addCriterion("wordNum <=", value, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumIn(List<Integer> values) {
            addCriterion("wordNum in", values, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumNotIn(List<Integer> values) {
            addCriterion("wordNum not in", values, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumBetween(Integer value1, Integer value2) {
            addCriterion("wordNum between", value1, value2, "wordNum");
            return (Criteria) this;
        }

        public Criteria andWordNumNotBetween(Integer value1, Integer value2) {
            addCriterion("wordNum not between", value1, value2, "wordNum");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIsNull() {
            addCriterion("printtime is null");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIsNotNull() {
            addCriterion("printtime is not null");
            return (Criteria) this;
        }

        public Criteria andPrintTimeEqualTo(String value) {
            addCriterion("printtime =", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotEqualTo(String value) {
            addCriterion("printtime <>", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeGreaterThan(String value) {
            addCriterion("printtime >", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeGreaterThanOrEqualTo(String value) {
            addCriterion("printtime >=", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLessThan(String value) {
            addCriterion("printtime <", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLessThanOrEqualTo(String value) {
            addCriterion("printtime <=", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeLike(String value) {
            addCriterion("printtime like", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotLike(String value) {
            addCriterion("printtime not like", value, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeIn(List<String> values) {
            addCriterion("printtime in", values, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotIn(List<String> values) {
            addCriterion("printtime not in", values, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeBetween(String value1, String value2) {
            addCriterion("printtime between", value1, value2, "printTime");
            return (Criteria) this;
        }

        public Criteria andPrintTimeNotBetween(String value1, String value2) {
            addCriterion("printtime not between", value1, value2, "printTime");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNull() {
            addCriterion("booksize is null");
            return (Criteria) this;
        }

        public Criteria andBookSizeIsNotNull() {
            addCriterion("booksize is not null");
            return (Criteria) this;
        }

        public Criteria andBookSizeEqualTo(Integer value) {
            addCriterion("booksize =", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotEqualTo(Integer value) {
            addCriterion("booksize <>", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThan(Integer value) {
            addCriterion("booksize >", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("booksize >=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThan(Integer value) {
            addCriterion("booksize <", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeLessThanOrEqualTo(Integer value) {
            addCriterion("booksize <=", value, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeIn(List<Integer> values) {
            addCriterion("booksize in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotIn(List<Integer> values) {
            addCriterion("booksize not in", values, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeBetween(Integer value1, Integer value2) {
            addCriterion("booksize between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andBookSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("booksize not between", value1, value2, "bookSize");
            return (Criteria) this;
        }

        public Criteria andPaperIsNull() {
            addCriterion("paper is null");
            return (Criteria) this;
        }

        public Criteria andPaperIsNotNull() {
            addCriterion("paper is not null");
            return (Criteria) this;
        }

        public Criteria andPaperEqualTo(String value) {
            addCriterion("paper =", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotEqualTo(String value) {
            addCriterion("paper <>", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperGreaterThan(String value) {
            addCriterion("paper >", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperGreaterThanOrEqualTo(String value) {
            addCriterion("paper >=", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperLessThan(String value) {
            addCriterion("paper <", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperLessThanOrEqualTo(String value) {
            addCriterion("paper <=", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperLike(String value) {
            addCriterion("paper like", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotLike(String value) {
            addCriterion("paper not like", value, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperIn(List<String> values) {
            addCriterion("paper in", values, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotIn(List<String> values) {
            addCriterion("paper not in", values, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperBetween(String value1, String value2) {
            addCriterion("paper between", value1, value2, "paper");
            return (Criteria) this;
        }

        public Criteria andPaperNotBetween(String value1, String value2) {
            addCriterion("paper not between", value1, value2, "paper");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("categoryId is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("categoryId is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("categoryId =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("categoryId <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("categoryId >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("categoryId >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("categoryId <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("categoryId <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("categoryId like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("categoryId not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("categoryId in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("categoryId not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("categoryId between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("categoryId not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andImageWIsNull() {
            addCriterion("image_w is null");
            return (Criteria) this;
        }

        public Criteria andImageWIsNotNull() {
            addCriterion("image_w is not null");
            return (Criteria) this;
        }

        public Criteria andImageWEqualTo(String value) {
            addCriterion("image_w =", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWNotEqualTo(String value) {
            addCriterion("image_w <>", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWGreaterThan(String value) {
            addCriterion("image_w >", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWGreaterThanOrEqualTo(String value) {
            addCriterion("image_w >=", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWLessThan(String value) {
            addCriterion("image_w <", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWLessThanOrEqualTo(String value) {
            addCriterion("image_w <=", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWLike(String value) {
            addCriterion("image_w like", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWNotLike(String value) {
            addCriterion("image_w not like", value, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWIn(List<String> values) {
            addCriterion("image_w in", values, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWNotIn(List<String> values) {
            addCriterion("image_w not in", values, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWBetween(String value1, String value2) {
            addCriterion("image_w between", value1, value2, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageWNotBetween(String value1, String value2) {
            addCriterion("image_w not between", value1, value2, "imageW");
            return (Criteria) this;
        }

        public Criteria andImageBIsNull() {
            addCriterion("image_b is null");
            return (Criteria) this;
        }

        public Criteria andImageBIsNotNull() {
            addCriterion("image_b is not null");
            return (Criteria) this;
        }

        public Criteria andImageBEqualTo(String value) {
            addCriterion("image_b =", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBNotEqualTo(String value) {
            addCriterion("image_b <>", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBGreaterThan(String value) {
            addCriterion("image_b >", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBGreaterThanOrEqualTo(String value) {
            addCriterion("image_b >=", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBLessThan(String value) {
            addCriterion("image_b <", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBLessThanOrEqualTo(String value) {
            addCriterion("image_b <=", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBLike(String value) {
            addCriterion("image_b like", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBNotLike(String value) {
            addCriterion("image_b not like", value, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBIn(List<String> values) {
            addCriterion("image_b in", values, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBNotIn(List<String> values) {
            addCriterion("image_b not in", values, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBBetween(String value1, String value2) {
            addCriterion("image_b between", value1, value2, "imageB");
            return (Criteria) this;
        }

        public Criteria andImageBNotBetween(String value1, String value2) {
            addCriterion("image_b not between", value1, value2, "imageB");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNull() {
            addCriterion("orderBy is null");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNotNull() {
            addCriterion("orderBy is not null");
            return (Criteria) this;
        }

        public Criteria andOrderByEqualTo(Integer value) {
            addCriterion("orderBy =", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotEqualTo(Integer value) {
            addCriterion("orderBy <>", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThan(Integer value) {
            addCriterion("orderBy >", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderBy >=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThan(Integer value) {
            addCriterion("orderBy <", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThanOrEqualTo(Integer value) {
            addCriterion("orderBy <=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByIn(List<Integer> values) {
            addCriterion("orderBy in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotIn(List<Integer> values) {
            addCriterion("orderBy not in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByBetween(Integer value1, Integer value2) {
            addCriterion("orderBy between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotBetween(Integer value1, Integer value2) {
            addCriterion("orderBy not between", value1, value2, "orderBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}