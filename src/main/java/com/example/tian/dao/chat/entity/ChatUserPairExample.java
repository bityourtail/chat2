package com.example.tian.dao.chat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatUserPairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChatUserPairExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPairUserIdIsNull() {
            addCriterion("pair_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPairUserIdIsNotNull() {
            addCriterion("pair_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPairUserIdEqualTo(String value) {
            addCriterion("pair_user_id =", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdNotEqualTo(String value) {
            addCriterion("pair_user_id <>", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdGreaterThan(String value) {
            addCriterion("pair_user_id >", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("pair_user_id >=", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdLessThan(String value) {
            addCriterion("pair_user_id <", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdLessThanOrEqualTo(String value) {
            addCriterion("pair_user_id <=", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdLike(String value) {
            addCriterion("pair_user_id like", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdNotLike(String value) {
            addCriterion("pair_user_id not like", value, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdIn(List<String> values) {
            addCriterion("pair_user_id in", values, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdNotIn(List<String> values) {
            addCriterion("pair_user_id not in", values, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdBetween(String value1, String value2) {
            addCriterion("pair_user_id between", value1, value2, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairUserIdNotBetween(String value1, String value2) {
            addCriterion("pair_user_id not between", value1, value2, "pairUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdIsNull() {
            addCriterion("paired_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdIsNotNull() {
            addCriterion("paired_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdEqualTo(String value) {
            addCriterion("paired_user_id =", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdNotEqualTo(String value) {
            addCriterion("paired_user_id <>", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdGreaterThan(String value) {
            addCriterion("paired_user_id >", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("paired_user_id >=", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdLessThan(String value) {
            addCriterion("paired_user_id <", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdLessThanOrEqualTo(String value) {
            addCriterion("paired_user_id <=", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdLike(String value) {
            addCriterion("paired_user_id like", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdNotLike(String value) {
            addCriterion("paired_user_id not like", value, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdIn(List<String> values) {
            addCriterion("paired_user_id in", values, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdNotIn(List<String> values) {
            addCriterion("paired_user_id not in", values, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdBetween(String value1, String value2) {
            addCriterion("paired_user_id between", value1, value2, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andPairedUserIdNotBetween(String value1, String value2) {
            addCriterion("paired_user_id not between", value1, value2, "pairedUserId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeIsNull() {
            addCriterion("db_create_time is null");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeIsNotNull() {
            addCriterion("db_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeEqualTo(Date value) {
            addCriterion("db_create_time =", value, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeNotEqualTo(Date value) {
            addCriterion("db_create_time <>", value, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeGreaterThan(Date value) {
            addCriterion("db_create_time >", value, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("db_create_time >=", value, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeLessThan(Date value) {
            addCriterion("db_create_time <", value, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("db_create_time <=", value, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeIn(List<Date> values) {
            addCriterion("db_create_time in", values, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeNotIn(List<Date> values) {
            addCriterion("db_create_time not in", values, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeBetween(Date value1, Date value2) {
            addCriterion("db_create_time between", value1, value2, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("db_create_time not between", value1, value2, "dbCreateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeIsNull() {
            addCriterion("db_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeIsNotNull() {
            addCriterion("db_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeEqualTo(Date value) {
            addCriterion("db_update_time =", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeNotEqualTo(Date value) {
            addCriterion("db_update_time <>", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeGreaterThan(Date value) {
            addCriterion("db_update_time >", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("db_update_time >=", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeLessThan(Date value) {
            addCriterion("db_update_time <", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("db_update_time <=", value, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeIn(List<Date> values) {
            addCriterion("db_update_time in", values, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeNotIn(List<Date> values) {
            addCriterion("db_update_time not in", values, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("db_update_time between", value1, value2, "dbUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDbUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("db_update_time not between", value1, value2, "dbUpdateTime");
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