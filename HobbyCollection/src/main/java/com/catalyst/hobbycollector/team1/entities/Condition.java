package com.catalyst.hobbycollector.team1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * use to get info for condition
 * 
 * @return
 */
@Entity
@Table(name = "condition")
public class Condition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "condition_id")
	private Integer conditionId;

	@Column(name = "condition_name")
	private String conditionName;

	/**
	 * @return the conditionId
	 */
	public Integer getConditionId() {
		return conditionId;
	}

	/**
	 * @param conditionId the conditionId to set
	 */
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	/**
	 * @return the conditionName
	 */
	public String getConditionName() {
		return conditionName;
	}

	/**
	 * @param conditionName the conditionName to set
	 */
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
}

