package com.zzg.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public CategoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(String value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(String value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(String value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(String value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(String value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(String value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLike(String value) {
            addCriterion("cid like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotLike(String value) {
            addCriterion("cid not like", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<String> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<String> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(String value1, String value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(String value1, String value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andMiaoshuIsNull() {
            addCriterion("miaoshu is null");
            return (Criteria) this;
        }

        public Criteria andMiaoshuIsNotNull() {
            addCriterion("miaoshu is not null");
            return (Criteria) this;
        }

        public Criteria andMiaoshuEqualTo(String value) {
            addCriterion("miaoshu =", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotEqualTo(String value) {
            addCriterion("miaoshu <>", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuGreaterThan(String value) {
            addCriterion("miaoshu >", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuGreaterThanOrEqualTo(String value) {
            addCriterion("miaoshu >=", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuLessThan(String value) {
            addCriterion("miaoshu <", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuLessThanOrEqualTo(String value) {
            addCriterion("miaoshu <=", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuLike(String value) {
            addCriterion("miaoshu like", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotLike(String value) {
            addCriterion("miaoshu not like", value, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuIn(List<String> values) {
            addCriterion("miaoshu in", values, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotIn(List<String> values) {
            addCriterion("miaoshu not in", values, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuBetween(String value1, String value2) {
            addCriterion("miaoshu between", value1, value2, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andMiaoshuNotBetween(String value1, String value2) {
            addCriterion("miaoshu not between", value1, value2, "miaoshu");
            return (Criteria) this;
        }

        public Criteria andShunxuIsNull() {
            addCriterion("shunxu is null");
            return (Criteria) this;
        }

        public Criteria andShunxuIsNotNull() {
            addCriterion("shunxu is not null");
            return (Criteria) this;
        }

        public Criteria andShunxuEqualTo(Integer value) {
            addCriterion("shunxu =", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuNotEqualTo(Integer value) {
            addCriterion("shunxu <>", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuGreaterThan(Integer value) {
            addCriterion("shunxu >", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuGreaterThanOrEqualTo(Integer value) {
            addCriterion("shunxu >=", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuLessThan(Integer value) {
            addCriterion("shunxu <", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuLessThanOrEqualTo(Integer value) {
            addCriterion("shunxu <=", value, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuIn(List<Integer> values) {
            addCriterion("shunxu in", values, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuNotIn(List<Integer> values) {
            addCriterion("shunxu not in", values, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuBetween(Integer value1, Integer value2) {
            addCriterion("shunxu between", value1, value2, "shunxu");
            return (Criteria) this;
        }

        public Criteria andShunxuNotBetween(Integer value1, Integer value2) {
            addCriterion("shunxu not between", value1, value2, "shunxu");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table category
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 22 08:32:33 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table category
     *
     * @mbggenerated Thu Jun 22 08:32:33 CST 2017
     */
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