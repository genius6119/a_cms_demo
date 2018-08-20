package cn.qimu.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class PositionTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionTypeExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIsNull() {
            addCriterion("position_type_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIsNotNull() {
            addCriterion("position_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameEqualTo(String value) {
            addCriterion("position_type_name =", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotEqualTo(String value) {
            addCriterion("position_type_name <>", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameGreaterThan(String value) {
            addCriterion("position_type_name >", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_type_name >=", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLessThan(String value) {
            addCriterion("position_type_name <", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLessThanOrEqualTo(String value) {
            addCriterion("position_type_name <=", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLike(String value) {
            addCriterion("position_type_name like", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotLike(String value) {
            addCriterion("position_type_name not like", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIn(List<String> values) {
            addCriterion("position_type_name in", values, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotIn(List<String> values) {
            addCriterion("position_type_name not in", values, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameBetween(String value1, String value2) {
            addCriterion("position_type_name between", value1, value2, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotBetween(String value1, String value2) {
            addCriterion("position_type_name not between", value1, value2, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionIconIsNull() {
            addCriterion("position_icon is null");
            return (Criteria) this;
        }

        public Criteria andPositionIconIsNotNull() {
            addCriterion("position_icon is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIconEqualTo(String value) {
            addCriterion("position_icon =", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconNotEqualTo(String value) {
            addCriterion("position_icon <>", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconGreaterThan(String value) {
            addCriterion("position_icon >", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconGreaterThanOrEqualTo(String value) {
            addCriterion("position_icon >=", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconLessThan(String value) {
            addCriterion("position_icon <", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconLessThanOrEqualTo(String value) {
            addCriterion("position_icon <=", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconLike(String value) {
            addCriterion("position_icon like", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconNotLike(String value) {
            addCriterion("position_icon not like", value, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconIn(List<String> values) {
            addCriterion("position_icon in", values, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconNotIn(List<String> values) {
            addCriterion("position_icon not in", values, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconBetween(String value1, String value2) {
            addCriterion("position_icon between", value1, value2, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andPositionIconNotBetween(String value1, String value2) {
            addCriterion("position_icon not between", value1, value2, "positionIcon");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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