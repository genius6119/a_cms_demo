package cn.qimu.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class BrandShoeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrandShoeExample() {
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(String value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(String value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(String value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(String value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(String value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(String value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLike(String value) {
            addCriterion("brand_id like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotLike(String value) {
            addCriterion("brand_id not like", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<String> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<String> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(String value1, String value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(String value1, String value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andShoeNameIsNull() {
            addCriterion("shoe_name is null");
            return (Criteria) this;
        }

        public Criteria andShoeNameIsNotNull() {
            addCriterion("shoe_name is not null");
            return (Criteria) this;
        }

        public Criteria andShoeNameEqualTo(String value) {
            addCriterion("shoe_name =", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameNotEqualTo(String value) {
            addCriterion("shoe_name <>", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameGreaterThan(String value) {
            addCriterion("shoe_name >", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_name >=", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameLessThan(String value) {
            addCriterion("shoe_name <", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameLessThanOrEqualTo(String value) {
            addCriterion("shoe_name <=", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameLike(String value) {
            addCriterion("shoe_name like", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameNotLike(String value) {
            addCriterion("shoe_name not like", value, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameIn(List<String> values) {
            addCriterion("shoe_name in", values, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameNotIn(List<String> values) {
            addCriterion("shoe_name not in", values, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameBetween(String value1, String value2) {
            addCriterion("shoe_name between", value1, value2, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoeNameNotBetween(String value1, String value2) {
            addCriterion("shoe_name not between", value1, value2, "shoeName");
            return (Criteria) this;
        }

        public Criteria andShoePictureIsNull() {
            addCriterion("shoe_picture is null");
            return (Criteria) this;
        }

        public Criteria andShoePictureIsNotNull() {
            addCriterion("shoe_picture is not null");
            return (Criteria) this;
        }

        public Criteria andShoePictureEqualTo(String value) {
            addCriterion("shoe_picture =", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureNotEqualTo(String value) {
            addCriterion("shoe_picture <>", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureGreaterThan(String value) {
            addCriterion("shoe_picture >", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_picture >=", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureLessThan(String value) {
            addCriterion("shoe_picture <", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureLessThanOrEqualTo(String value) {
            addCriterion("shoe_picture <=", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureLike(String value) {
            addCriterion("shoe_picture like", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureNotLike(String value) {
            addCriterion("shoe_picture not like", value, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureIn(List<String> values) {
            addCriterion("shoe_picture in", values, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureNotIn(List<String> values) {
            addCriterion("shoe_picture not in", values, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureBetween(String value1, String value2) {
            addCriterion("shoe_picture between", value1, value2, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoePictureNotBetween(String value1, String value2) {
            addCriterion("shoe_picture not between", value1, value2, "shoePicture");
            return (Criteria) this;
        }

        public Criteria andShoeUrlIsNull() {
            addCriterion("shoe_url is null");
            return (Criteria) this;
        }

        public Criteria andShoeUrlIsNotNull() {
            addCriterion("shoe_url is not null");
            return (Criteria) this;
        }

        public Criteria andShoeUrlEqualTo(String value) {
            addCriterion("shoe_url =", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlNotEqualTo(String value) {
            addCriterion("shoe_url <>", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlGreaterThan(String value) {
            addCriterion("shoe_url >", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("shoe_url >=", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlLessThan(String value) {
            addCriterion("shoe_url <", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlLessThanOrEqualTo(String value) {
            addCriterion("shoe_url <=", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlLike(String value) {
            addCriterion("shoe_url like", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlNotLike(String value) {
            addCriterion("shoe_url not like", value, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlIn(List<String> values) {
            addCriterion("shoe_url in", values, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlNotIn(List<String> values) {
            addCriterion("shoe_url not in", values, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlBetween(String value1, String value2) {
            addCriterion("shoe_url between", value1, value2, "shoeUrl");
            return (Criteria) this;
        }

        public Criteria andShoeUrlNotBetween(String value1, String value2) {
            addCriterion("shoe_url not between", value1, value2, "shoeUrl");
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