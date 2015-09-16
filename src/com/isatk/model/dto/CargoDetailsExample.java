package com.isatk.model.dto;

import com.isatk.model.bean.Page;
import java.util.ArrayList;
import java.util.List;

public class CargoDetailsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	protected Page page;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public CargoDetailsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andInsuranceIsNull() {
			addCriterion("insurance is null");
			return (Criteria) this;
		}

		public Criteria andInsuranceIsNotNull() {
			addCriterion("insurance is not null");
			return (Criteria) this;
		}

		public Criteria andInsuranceEqualTo(Integer value) {
			addCriterion("insurance =", value, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceNotEqualTo(Integer value) {
			addCriterion("insurance <>", value, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceGreaterThan(Integer value) {
			addCriterion("insurance >", value, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceGreaterThanOrEqualTo(Integer value) {
			addCriterion("insurance >=", value, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceLessThan(Integer value) {
			addCriterion("insurance <", value, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceLessThanOrEqualTo(Integer value) {
			addCriterion("insurance <=", value, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceIn(List<Integer> values) {
			addCriterion("insurance in", values, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceNotIn(List<Integer> values) {
			addCriterion("insurance not in", values, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceBetween(Integer value1, Integer value2) {
			addCriterion("insurance between", value1, value2, "insurance");
			return (Criteria) this;
		}

		public Criteria andInsuranceNotBetween(Integer value1, Integer value2) {
			addCriterion("insurance not between", value1, value2, "insurance");
			return (Criteria) this;
		}

		public Criteria andNumIsNull() {
			addCriterion("num is null");
			return (Criteria) this;
		}

		public Criteria andNumIsNotNull() {
			addCriterion("num is not null");
			return (Criteria) this;
		}

		public Criteria andNumEqualTo(String value) {
			addCriterion("num =", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotEqualTo(String value) {
			addCriterion("num <>", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThan(String value) {
			addCriterion("num >", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThanOrEqualTo(String value) {
			addCriterion("num >=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThan(String value) {
			addCriterion("num <", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThanOrEqualTo(String value) {
			addCriterion("num <=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLike(String value) {
			addCriterion("num like", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotLike(String value) {
			addCriterion("num not like", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumIn(List<String> values) {
			addCriterion("num in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotIn(List<String> values) {
			addCriterion("num not in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumBetween(String value1, String value2) {
			addCriterion("num between", value1, value2, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotBetween(String value1, String value2) {
			addCriterion("num not between", value1, value2, "num");
			return (Criteria) this;
		}

		public Criteria andFaIdIsNull() {
			addCriterion("fa_id is null");
			return (Criteria) this;
		}

		public Criteria andFaIdIsNotNull() {
			addCriterion("fa_id is not null");
			return (Criteria) this;
		}

		public Criteria andFaIdEqualTo(Long value) {
			addCriterion("fa_id =", value, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdNotEqualTo(Long value) {
			addCriterion("fa_id <>", value, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdGreaterThan(Long value) {
			addCriterion("fa_id >", value, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdGreaterThanOrEqualTo(Long value) {
			addCriterion("fa_id >=", value, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdLessThan(Long value) {
			addCriterion("fa_id <", value, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdLessThanOrEqualTo(Long value) {
			addCriterion("fa_id <=", value, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdIn(List<Long> values) {
			addCriterion("fa_id in", values, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdNotIn(List<Long> values) {
			addCriterion("fa_id not in", values, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdBetween(Long value1, Long value2) {
			addCriterion("fa_id between", value1, value2, "faId");
			return (Criteria) this;
		}

		public Criteria andFaIdNotBetween(Long value1, Long value2) {
			addCriterion("fa_id not between", value1, value2, "faId");
			return (Criteria) this;
		}

		public Criteria andNameLikeInsensitive(String value) {
			addCriterion("upper(name) like", value.toUpperCase(), "name");
			return (Criteria) this;
		}

		public Criteria andNumLikeInsensitive(String value) {
			addCriterion("upper(num) like", value.toUpperCase(), "num");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table cargo_details
	 * @mbggenerated  Sun May 10 19:46:09 CST 2015
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cargo_details
     *
     * @mbggenerated do_not_delete_during_merge Tue May 05 20:02:36 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}