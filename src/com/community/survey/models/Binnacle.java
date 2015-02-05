package com.community.survey.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

public class Binnacle {

	public static final String CREATED_ON = "CreatedOn";
	public static final String CREATED_BY = "CreatedBy";
	public static final String MODIFIED_ON = "ModifiedOn";
	public static final String MODIFIED_BY = "ModifiedBy";

	public Binnacle() {

	}

	public Binnacle(Date createdOn, User createdBy) {
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdOn;
	}

	public Date getModifiedDate() {
		return this.modifiedOn;
	}

	public User getCreator() {
		return createdBy;
	}

	public User getModifier() {
		return createdBy;
	}

	@SerializedName(CREATED_ON)
	@DatabaseField(columnName = CREATED_ON)
	private Date createdOn;
	@SerializedName(MODIFIED_ON)
	@DatabaseField(columnName = MODIFIED_ON)
	private Date modifiedOn;
	@SerializedName(CREATED_BY)
	@DatabaseField(columnName = CREATED_BY, foreign = true, foreignColumnName = User.ID, canBeNull = true)
	private User createdBy;
	@SerializedName(MODIFIED_BY)
	@DatabaseField(columnName = MODIFIED_BY, foreign = true, foreignColumnName = User.ID, canBeNull = true)
	private User modifiedBy;
}
