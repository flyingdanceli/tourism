package com.isatk.model.dto;

import com.isatk.model.bean.Page;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CarFeeExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	protected Page page;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public CarFeeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
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

		public Criteria andGasIsNull() {
			addCriterion("gas is null");
			return (Criteria) this;
		}

		public Criteria andGasIsNotNull() {
			addCriterion("gas is not null");
			return (Criteria) this;
		}

		public Criteria andGasEqualTo(Integer value) {
			addCriterion("gas =", value, "gas");
			return (Criteria) this;
		}

		public Criteria andGasNotEqualTo(Integer value) {
			addCriterion("gas <>", value, "gas");
			return (Criteria) this;
		}

		public Criteria andGasGreaterThan(Integer value) {
			addCriterion("gas >", value, "gas");
			return (Criteria) this;
		}

		public Criteria andGasGreaterThanOrEqualTo(Integer value) {
			addCriterion("gas >=", value, "gas");
			return (Criteria) this;
		}

		public Criteria andGasLessThan(Integer value) {
			addCriterion("gas <", value, "gas");
			return (Criteria) this;
		}

		public Criteria andGasLessThanOrEqualTo(Integer value) {
			addCriterion("gas <=", value, "gas");
			return (Criteria) this;
		}

		public Criteria andGasIn(List<Integer> values) {
			addCriterion("gas in", values, "gas");
			return (Criteria) this;
		}

		public Criteria andGasNotIn(List<Integer> values) {
			addCriterion("gas not in", values, "gas");
			return (Criteria) this;
		}

		public Criteria andGasBetween(Integer value1, Integer value2) {
			addCriterion("gas between", value1, value2, "gas");
			return (Criteria) this;
		}

		public Criteria andGasNotBetween(Integer value1, Integer value2) {
			addCriterion("gas not between", value1, value2, "gas");
			return (Criteria) this;
		}

		public Criteria andTollsIsNull() {
			addCriterion("tolls is null");
			return (Criteria) this;
		}

		public Criteria andTollsIsNotNull() {
			addCriterion("tolls is not null");
			return (Criteria) this;
		}

		public Criteria andTollsEqualTo(Integer value) {
			addCriterion("tolls =", value, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsNotEqualTo(Integer value) {
			addCriterion("tolls <>", value, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsGreaterThan(Integer value) {
			addCriterion("tolls >", value, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsGreaterThanOrEqualTo(Integer value) {
			addCriterion("tolls >=", value, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsLessThan(Integer value) {
			addCriterion("tolls <", value, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsLessThanOrEqualTo(Integer value) {
			addCriterion("tolls <=", value, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsIn(List<Integer> values) {
			addCriterion("tolls in", values, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsNotIn(List<Integer> values) {
			addCriterion("tolls not in", values, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsBetween(Integer value1, Integer value2) {
			addCriterion("tolls between", value1, value2, "tolls");
			return (Criteria) this;
		}

		public Criteria andTollsNotBetween(Integer value1, Integer value2) {
			addCriterion("tolls not between", value1, value2, "tolls");
			return (Criteria) this;
		}

		public Criteria andWaterIsNull() {
			addCriterion("water is null");
			return (Criteria) this;
		}

		public Criteria andWaterIsNotNull() {
			addCriterion("water is not null");
			return (Criteria) this;
		}

		public Criteria andWaterEqualTo(Integer value) {
			addCriterion("water =", value, "water");
			return (Criteria) this;
		}

		public Criteria andWaterNotEqualTo(Integer value) {
			addCriterion("water <>", value, "water");
			return (Criteria) this;
		}

		public Criteria andWaterGreaterThan(Integer value) {
			addCriterion("water >", value, "water");
			return (Criteria) this;
		}

		public Criteria andWaterGreaterThanOrEqualTo(Integer value) {
			addCriterion("water >=", value, "water");
			return (Criteria) this;
		}

		public Criteria andWaterLessThan(Integer value) {
			addCriterion("water <", value, "water");
			return (Criteria) this;
		}

		public Criteria andWaterLessThanOrEqualTo(Integer value) {
			addCriterion("water <=", value, "water");
			return (Criteria) this;
		}

		public Criteria andWaterIn(List<Integer> values) {
			addCriterion("water in", values, "water");
			return (Criteria) this;
		}

		public Criteria andWaterNotIn(List<Integer> values) {
			addCriterion("water not in", values, "water");
			return (Criteria) this;
		}

		public Criteria andWaterBetween(Integer value1, Integer value2) {
			addCriterion("water between", value1, value2, "water");
			return (Criteria) this;
		}

		public Criteria andWaterNotBetween(Integer value1, Integer value2) {
			addCriterion("water not between", value1, value2, "water");
			return (Criteria) this;
		}

		public Criteria andEngineOilIsNull() {
			addCriterion("engine_oil is null");
			return (Criteria) this;
		}

		public Criteria andEngineOilIsNotNull() {
			addCriterion("engine_oil is not null");
			return (Criteria) this;
		}

		public Criteria andEngineOilEqualTo(Integer value) {
			addCriterion("engine_oil =", value, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilNotEqualTo(Integer value) {
			addCriterion("engine_oil <>", value, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilGreaterThan(Integer value) {
			addCriterion("engine_oil >", value, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilGreaterThanOrEqualTo(Integer value) {
			addCriterion("engine_oil >=", value, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilLessThan(Integer value) {
			addCriterion("engine_oil <", value, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilLessThanOrEqualTo(Integer value) {
			addCriterion("engine_oil <=", value, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilIn(List<Integer> values) {
			addCriterion("engine_oil in", values, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilNotIn(List<Integer> values) {
			addCriterion("engine_oil not in", values, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilBetween(Integer value1, Integer value2) {
			addCriterion("engine_oil between", value1, value2, "engineOil");
			return (Criteria) this;
		}

		public Criteria andEngineOilNotBetween(Integer value1, Integer value2) {
			addCriterion("engine_oil not between", value1, value2, "engineOil");
			return (Criteria) this;
		}

		public Criteria andServiceIsNull() {
			addCriterion("service is null");
			return (Criteria) this;
		}

		public Criteria andServiceIsNotNull() {
			addCriterion("service is not null");
			return (Criteria) this;
		}

		public Criteria andServiceEqualTo(Integer value) {
			addCriterion("service =", value, "service");
			return (Criteria) this;
		}

		public Criteria andServiceNotEqualTo(Integer value) {
			addCriterion("service <>", value, "service");
			return (Criteria) this;
		}

		public Criteria andServiceGreaterThan(Integer value) {
			addCriterion("service >", value, "service");
			return (Criteria) this;
		}

		public Criteria andServiceGreaterThanOrEqualTo(Integer value) {
			addCriterion("service >=", value, "service");
			return (Criteria) this;
		}

		public Criteria andServiceLessThan(Integer value) {
			addCriterion("service <", value, "service");
			return (Criteria) this;
		}

		public Criteria andServiceLessThanOrEqualTo(Integer value) {
			addCriterion("service <=", value, "service");
			return (Criteria) this;
		}

		public Criteria andServiceIn(List<Integer> values) {
			addCriterion("service in", values, "service");
			return (Criteria) this;
		}

		public Criteria andServiceNotIn(List<Integer> values) {
			addCriterion("service not in", values, "service");
			return (Criteria) this;
		}

		public Criteria andServiceBetween(Integer value1, Integer value2) {
			addCriterion("service between", value1, value2, "service");
			return (Criteria) this;
		}

		public Criteria andServiceNotBetween(Integer value1, Integer value2) {
			addCriterion("service not between", value1, value2, "service");
			return (Criteria) this;
		}

		public Criteria andButterIsNull() {
			addCriterion("butter is null");
			return (Criteria) this;
		}

		public Criteria andButterIsNotNull() {
			addCriterion("butter is not null");
			return (Criteria) this;
		}

		public Criteria andButterEqualTo(Integer value) {
			addCriterion("butter =", value, "butter");
			return (Criteria) this;
		}

		public Criteria andButterNotEqualTo(Integer value) {
			addCriterion("butter <>", value, "butter");
			return (Criteria) this;
		}

		public Criteria andButterGreaterThan(Integer value) {
			addCriterion("butter >", value, "butter");
			return (Criteria) this;
		}

		public Criteria andButterGreaterThanOrEqualTo(Integer value) {
			addCriterion("butter >=", value, "butter");
			return (Criteria) this;
		}

		public Criteria andButterLessThan(Integer value) {
			addCriterion("butter <", value, "butter");
			return (Criteria) this;
		}

		public Criteria andButterLessThanOrEqualTo(Integer value) {
			addCriterion("butter <=", value, "butter");
			return (Criteria) this;
		}

		public Criteria andButterIn(List<Integer> values) {
			addCriterion("butter in", values, "butter");
			return (Criteria) this;
		}

		public Criteria andButterNotIn(List<Integer> values) {
			addCriterion("butter not in", values, "butter");
			return (Criteria) this;
		}

		public Criteria andButterBetween(Integer value1, Integer value2) {
			addCriterion("butter between", value1, value2, "butter");
			return (Criteria) this;
		}

		public Criteria andButterNotBetween(Integer value1, Integer value2) {
			addCriterion("butter not between", value1, value2, "butter");
			return (Criteria) this;
		}

		public Criteria andOtherIsNull() {
			addCriterion("other is null");
			return (Criteria) this;
		}

		public Criteria andOtherIsNotNull() {
			addCriterion("other is not null");
			return (Criteria) this;
		}

		public Criteria andOtherEqualTo(Integer value) {
			addCriterion("other =", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotEqualTo(Integer value) {
			addCriterion("other <>", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThan(Integer value) {
			addCriterion("other >", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherGreaterThanOrEqualTo(Integer value) {
			addCriterion("other >=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThan(Integer value) {
			addCriterion("other <", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherLessThanOrEqualTo(Integer value) {
			addCriterion("other <=", value, "other");
			return (Criteria) this;
		}

		public Criteria andOtherIn(List<Integer> values) {
			addCriterion("other in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotIn(List<Integer> values) {
			addCriterion("other not in", values, "other");
			return (Criteria) this;
		}

		public Criteria andOtherBetween(Integer value1, Integer value2) {
			addCriterion("other between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andOtherNotBetween(Integer value1, Integer value2) {
			addCriterion("other not between", value1, value2, "other");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andCarIdIsNull() {
			addCriterion("car_id is null");
			return (Criteria) this;
		}

		public Criteria andCarIdIsNotNull() {
			addCriterion("car_id is not null");
			return (Criteria) this;
		}

		public Criteria andCarIdEqualTo(Long value) {
			addCriterion("car_id =", value, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdNotEqualTo(Long value) {
			addCriterion("car_id <>", value, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdGreaterThan(Long value) {
			addCriterion("car_id >", value, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdGreaterThanOrEqualTo(Long value) {
			addCriterion("car_id >=", value, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdLessThan(Long value) {
			addCriterion("car_id <", value, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdLessThanOrEqualTo(Long value) {
			addCriterion("car_id <=", value, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdIn(List<Long> values) {
			addCriterion("car_id in", values, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdNotIn(List<Long> values) {
			addCriterion("car_id not in", values, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdBetween(Long value1, Long value2) {
			addCriterion("car_id between", value1, value2, "carId");
			return (Criteria) this;
		}

		public Criteria andCarIdNotBetween(Long value1, Long value2) {
			addCriterion("car_id not between", value1, value2, "carId");
			return (Criteria) this;
		}

		public Criteria andInsDateIsNull() {
			addCriterion("ins_date is null");
			return (Criteria) this;
		}

		public Criteria andInsDateIsNotNull() {
			addCriterion("ins_date is not null");
			return (Criteria) this;
		}

		public Criteria andInsDateEqualTo(Date value) {
			addCriterion("ins_date =", value, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateNotEqualTo(Date value) {
			addCriterion("ins_date <>", value, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateGreaterThan(Date value) {
			addCriterion("ins_date >", value, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ins_date >=", value, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateLessThan(Date value) {
			addCriterion("ins_date <", value, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateLessThanOrEqualTo(Date value) {
			addCriterion("ins_date <=", value, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateIn(List<Date> values) {
			addCriterion("ins_date in", values, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateNotIn(List<Date> values) {
			addCriterion("ins_date not in", values, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateBetween(Date value1, Date value2) {
			addCriterion("ins_date between", value1, value2, "insDate");
			return (Criteria) this;
		}

		public Criteria andInsDateNotBetween(Date value1, Date value2) {
			addCriterion("ins_date not between", value1, value2, "insDate");
			return (Criteria) this;
		}

		public Criteria andRemarkLikeInsensitive(String value) {
			addCriterion("upper(remark) like", value.toUpperCase(), "remark");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table car_fee
	 * @mbggenerated  Sat May 23 10:51:13 CST 2015
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
     * This class corresponds to the database table car_fee
     *
     * @mbggenerated do_not_delete_during_merge Sat May 23 10:41:23 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}