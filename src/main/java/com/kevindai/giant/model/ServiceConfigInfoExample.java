package com.kevindai.giant.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceConfigInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceConfigInfoExample() {
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

        public Criteria andServiceCodeIsNull() {
            addCriterion("service_code is null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIsNotNull() {
            addCriterion("service_code is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCodeEqualTo(String value) {
            addCriterion("service_code =", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotEqualTo(String value) {
            addCriterion("service_code <>", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThan(String value) {
            addCriterion("service_code >", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("service_code >=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThan(String value) {
            addCriterion("service_code <", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLessThanOrEqualTo(String value) {
            addCriterion("service_code <=", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeLike(String value) {
            addCriterion("service_code like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotLike(String value) {
            addCriterion("service_code not like", value, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeIn(List<String> values) {
            addCriterion("service_code in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotIn(List<String> values) {
            addCriterion("service_code not in", values, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeBetween(String value1, String value2) {
            addCriterion("service_code between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceCodeNotBetween(String value1, String value2) {
            addCriterion("service_code not between", value1, value2, "serviceCode");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Long value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Long value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Long value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Long value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Long value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Long> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Long> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Long value1, Long value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Long value1, Long value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(Integer value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(Integer value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(Integer value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(Integer value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<Integer> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<Integer> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeIsNull() {
            addCriterion("method_type is null");
            return (Criteria) this;
        }

        public Criteria andMethodTypeIsNotNull() {
            addCriterion("method_type is not null");
            return (Criteria) this;
        }

        public Criteria andMethodTypeEqualTo(String value) {
            addCriterion("method_type =", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeNotEqualTo(String value) {
            addCriterion("method_type <>", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeGreaterThan(String value) {
            addCriterion("method_type >", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("method_type >=", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeLessThan(String value) {
            addCriterion("method_type <", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeLessThanOrEqualTo(String value) {
            addCriterion("method_type <=", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeLike(String value) {
            addCriterion("method_type like", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeNotLike(String value) {
            addCriterion("method_type not like", value, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeIn(List<String> values) {
            addCriterion("method_type in", values, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeNotIn(List<String> values) {
            addCriterion("method_type not in", values, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeBetween(String value1, String value2) {
            addCriterion("method_type between", value1, value2, "methodType");
            return (Criteria) this;
        }

        public Criteria andMethodTypeNotBetween(String value1, String value2) {
            addCriterion("method_type not between", value1, value2, "methodType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNull() {
            addCriterion("content_type is null");
            return (Criteria) this;
        }

        public Criteria andContentTypeIsNotNull() {
            addCriterion("content_type is not null");
            return (Criteria) this;
        }

        public Criteria andContentTypeEqualTo(String value) {
            addCriterion("content_type =", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotEqualTo(String value) {
            addCriterion("content_type <>", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThan(String value) {
            addCriterion("content_type >", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("content_type >=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThan(String value) {
            addCriterion("content_type <", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLessThanOrEqualTo(String value) {
            addCriterion("content_type <=", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeLike(String value) {
            addCriterion("content_type like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotLike(String value) {
            addCriterion("content_type not like", value, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeIn(List<String> values) {
            addCriterion("content_type in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotIn(List<String> values) {
            addCriterion("content_type not in", values, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeBetween(String value1, String value2) {
            addCriterion("content_type between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andContentTypeNotBetween(String value1, String value2) {
            addCriterion("content_type not between", value1, value2, "contentType");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeIsNull() {
            addCriterion("billing_service_code is null");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeIsNotNull() {
            addCriterion("billing_service_code is not null");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeEqualTo(String value) {
            addCriterion("billing_service_code =", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeNotEqualTo(String value) {
            addCriterion("billing_service_code <>", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeGreaterThan(String value) {
            addCriterion("billing_service_code >", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("billing_service_code >=", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeLessThan(String value) {
            addCriterion("billing_service_code <", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeLessThanOrEqualTo(String value) {
            addCriterion("billing_service_code <=", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeLike(String value) {
            addCriterion("billing_service_code like", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeNotLike(String value) {
            addCriterion("billing_service_code not like", value, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeIn(List<String> values) {
            addCriterion("billing_service_code in", values, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeNotIn(List<String> values) {
            addCriterion("billing_service_code not in", values, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeBetween(String value1, String value2) {
            addCriterion("billing_service_code between", value1, value2, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andBillingServiceCodeNotBetween(String value1, String value2) {
            addCriterion("billing_service_code not between", value1, value2, "billingServiceCode");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameIsNull() {
            addCriterion("operate_by_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameIsNotNull() {
            addCriterion("operate_by_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameEqualTo(String value) {
            addCriterion("operate_by_user_name =", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameNotEqualTo(String value) {
            addCriterion("operate_by_user_name <>", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameGreaterThan(String value) {
            addCriterion("operate_by_user_name >", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("operate_by_user_name >=", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameLessThan(String value) {
            addCriterion("operate_by_user_name <", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameLessThanOrEqualTo(String value) {
            addCriterion("operate_by_user_name <=", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameLike(String value) {
            addCriterion("operate_by_user_name like", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameNotLike(String value) {
            addCriterion("operate_by_user_name not like", value, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameIn(List<String> values) {
            addCriterion("operate_by_user_name in", values, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameNotIn(List<String> values) {
            addCriterion("operate_by_user_name not in", values, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameBetween(String value1, String value2) {
            addCriterion("operate_by_user_name between", value1, value2, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserNameNotBetween(String value1, String value2) {
            addCriterion("operate_by_user_name not between", value1, value2, "operateByUserName");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdIsNull() {
            addCriterion("operate_by_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdIsNotNull() {
            addCriterion("operate_by_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdEqualTo(String value) {
            addCriterion("operate_by_user_id =", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdNotEqualTo(String value) {
            addCriterion("operate_by_user_id <>", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdGreaterThan(String value) {
            addCriterion("operate_by_user_id >", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("operate_by_user_id >=", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdLessThan(String value) {
            addCriterion("operate_by_user_id <", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdLessThanOrEqualTo(String value) {
            addCriterion("operate_by_user_id <=", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdLike(String value) {
            addCriterion("operate_by_user_id like", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdNotLike(String value) {
            addCriterion("operate_by_user_id not like", value, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdIn(List<String> values) {
            addCriterion("operate_by_user_id in", values, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdNotIn(List<String> values) {
            addCriterion("operate_by_user_id not in", values, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdBetween(String value1, String value2) {
            addCriterion("operate_by_user_id between", value1, value2, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andOperateByUserIdNotBetween(String value1, String value2) {
            addCriterion("operate_by_user_id not between", value1, value2, "operateByUserId");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
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

        public Criteria andBillingConfigIsNull() {
            addCriterion("billing_config is null");
            return (Criteria) this;
        }

        public Criteria andBillingConfigIsNotNull() {
            addCriterion("billing_config is not null");
            return (Criteria) this;
        }

        public Criteria andBillingConfigEqualTo(String value) {
            addCriterion("billing_config =", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigNotEqualTo(String value) {
            addCriterion("billing_config <>", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigGreaterThan(String value) {
            addCriterion("billing_config >", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigGreaterThanOrEqualTo(String value) {
            addCriterion("billing_config >=", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigLessThan(String value) {
            addCriterion("billing_config <", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigLessThanOrEqualTo(String value) {
            addCriterion("billing_config <=", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigLike(String value) {
            addCriterion("billing_config like", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigNotLike(String value) {
            addCriterion("billing_config not like", value, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigIn(List<String> values) {
            addCriterion("billing_config in", values, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigNotIn(List<String> values) {
            addCriterion("billing_config not in", values, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigBetween(String value1, String value2) {
            addCriterion("billing_config between", value1, value2, "billingConfig");
            return (Criteria) this;
        }

        public Criteria andBillingConfigNotBetween(String value1, String value2) {
            addCriterion("billing_config not between", value1, value2, "billingConfig");
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