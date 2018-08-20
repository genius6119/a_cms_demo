package cn.qimu.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class PositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionExample() {
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

        public Criteria andPositionTypeIdIsNull() {
            addCriterion("position_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdIsNotNull() {
            addCriterion("position_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdEqualTo(Integer value) {
            addCriterion("position_type_id =", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdNotEqualTo(Integer value) {
            addCriterion("position_type_id <>", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdGreaterThan(Integer value) {
            addCriterion("position_type_id >", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_type_id >=", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdLessThan(Integer value) {
            addCriterion("position_type_id <", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("position_type_id <=", value, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdIn(List<Integer> values) {
            addCriterion("position_type_id in", values, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdNotIn(List<Integer> values) {
            addCriterion("position_type_id not in", values, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("position_type_id between", value1, value2, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("position_type_id not between", value1, value2, "positionTypeId");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("position_name =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andRequireNumberIsNull() {
            addCriterion("require_number is null");
            return (Criteria) this;
        }

        public Criteria andRequireNumberIsNotNull() {
            addCriterion("require_number is not null");
            return (Criteria) this;
        }

        public Criteria andRequireNumberEqualTo(Integer value) {
            addCriterion("require_number =", value, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberNotEqualTo(Integer value) {
            addCriterion("require_number <>", value, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberGreaterThan(Integer value) {
            addCriterion("require_number >", value, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("require_number >=", value, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberLessThan(Integer value) {
            addCriterion("require_number <", value, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberLessThanOrEqualTo(Integer value) {
            addCriterion("require_number <=", value, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberIn(List<Integer> values) {
            addCriterion("require_number in", values, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberNotIn(List<Integer> values) {
            addCriterion("require_number not in", values, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberBetween(Integer value1, Integer value2) {
            addCriterion("require_number between", value1, value2, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andRequireNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("require_number not between", value1, value2, "requireNumber");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNull() {
            addCriterion("work_experience is null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIsNotNull() {
            addCriterion("work_experience is not null");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceEqualTo(Integer value) {
            addCriterion("work_experience =", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotEqualTo(Integer value) {
            addCriterion("work_experience <>", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThan(Integer value) {
            addCriterion("work_experience >", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_experience >=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThan(Integer value) {
            addCriterion("work_experience <", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("work_experience <=", value, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceIn(List<Integer> values) {
            addCriterion("work_experience in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotIn(List<Integer> values) {
            addCriterion("work_experience not in", values, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceBetween(Integer value1, Integer value2) {
            addCriterion("work_experience between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andWorkExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("work_experience not between", value1, value2, "workExperience");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudIsNull() {
            addCriterion("education_backgroud is null");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudIsNotNull() {
            addCriterion("education_backgroud is not null");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudEqualTo(String value) {
            addCriterion("education_backgroud =", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudNotEqualTo(String value) {
            addCriterion("education_backgroud <>", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudGreaterThan(String value) {
            addCriterion("education_backgroud >", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudGreaterThanOrEqualTo(String value) {
            addCriterion("education_backgroud >=", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudLessThan(String value) {
            addCriterion("education_backgroud <", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudLessThanOrEqualTo(String value) {
            addCriterion("education_backgroud <=", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudLike(String value) {
            addCriterion("education_backgroud like", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudNotLike(String value) {
            addCriterion("education_backgroud not like", value, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudIn(List<String> values) {
            addCriterion("education_backgroud in", values, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudNotIn(List<String> values) {
            addCriterion("education_backgroud not in", values, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudBetween(String value1, String value2) {
            addCriterion("education_backgroud between", value1, value2, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andEducationBackgroudNotBetween(String value1, String value2) {
            addCriterion("education_backgroud not between", value1, value2, "educationBackgroud");
            return (Criteria) this;
        }

        public Criteria andPositionRequireIsNull() {
            addCriterion("position_require is null");
            return (Criteria) this;
        }

        public Criteria andPositionRequireIsNotNull() {
            addCriterion("position_require is not null");
            return (Criteria) this;
        }

        public Criteria andPositionRequireEqualTo(String value) {
            addCriterion("position_require =", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotEqualTo(String value) {
            addCriterion("position_require <>", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireGreaterThan(String value) {
            addCriterion("position_require >", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireGreaterThanOrEqualTo(String value) {
            addCriterion("position_require >=", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLessThan(String value) {
            addCriterion("position_require <", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLessThanOrEqualTo(String value) {
            addCriterion("position_require <=", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireLike(String value) {
            addCriterion("position_require like", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotLike(String value) {
            addCriterion("position_require not like", value, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireIn(List<String> values) {
            addCriterion("position_require in", values, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotIn(List<String> values) {
            addCriterion("position_require not in", values, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireBetween(String value1, String value2) {
            addCriterion("position_require between", value1, value2, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionRequireNotBetween(String value1, String value2) {
            addCriterion("position_require not between", value1, value2, "positionRequire");
            return (Criteria) this;
        }

        public Criteria andPositionDutyIsNull() {
            addCriterion("position_duty is null");
            return (Criteria) this;
        }

        public Criteria andPositionDutyIsNotNull() {
            addCriterion("position_duty is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDutyEqualTo(String value) {
            addCriterion("position_duty =", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyNotEqualTo(String value) {
            addCriterion("position_duty <>", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyGreaterThan(String value) {
            addCriterion("position_duty >", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyGreaterThanOrEqualTo(String value) {
            addCriterion("position_duty >=", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyLessThan(String value) {
            addCriterion("position_duty <", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyLessThanOrEqualTo(String value) {
            addCriterion("position_duty <=", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyLike(String value) {
            addCriterion("position_duty like", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyNotLike(String value) {
            addCriterion("position_duty not like", value, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyIn(List<String> values) {
            addCriterion("position_duty in", values, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyNotIn(List<String> values) {
            addCriterion("position_duty not in", values, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyBetween(String value1, String value2) {
            addCriterion("position_duty between", value1, value2, "positionDuty");
            return (Criteria) this;
        }

        public Criteria andPositionDutyNotBetween(String value1, String value2) {
            addCriterion("position_duty not between", value1, value2, "positionDuty");
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