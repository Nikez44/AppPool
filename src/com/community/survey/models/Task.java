package com.community.survey.models;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Task {

	public static final String ID = "Id";
	public static final String NAME = "Name";
	public static final String DESCRIPTION = "Description";
	public static final String USER_CREATOR = "UserCreator";
	public static final String EXPIRATION = "Expiration";
	public static final String TASK_TYPE = "TaskType";

	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	@SerializedName(ID)
	@DatabaseField(columnName = ID, generatedId = true)
	private int id;
	@SerializedName(NAME)
	@DatabaseField(columnName = NAME)
	private String name;
	@SerializedName(DESCRIPTION)
	@DatabaseField(columnName = DESCRIPTION)
	private String description;
	@SerializedName(USER_CREATOR)
	@DatabaseField(columnName = USER_CREATOR, foreign = true, foreignColumnName = User.ID)
	private User userCreator;
	@SerializedName(EXPIRATION)
	@DatabaseField(columnName = EXPIRATION)
	private Date expiration;
	@SerializedName(TASK_TYPE)
	@DatabaseField(columnName = TASK_TYPE, dataType = DataType.ENUM_INTEGER)
	private TaskType taskType;

}
