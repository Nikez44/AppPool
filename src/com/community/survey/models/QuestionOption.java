package com.community.survey.models;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class QuestionOption {

	public static final String ID = "Id";
	public static final String OPTION = "Options";
	public static final String QUESTION_TEMPLATE = "QuestionTemplate";

	public QuestionOption() {
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof QuestionOption) {
			QuestionOption questionOption = (QuestionOption) o;
			return questionOption.getId() == getId();
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public QuestionTemplate getQuestionTemplate() {
		return questionTemplate;
	}

	public void setQuestionTemplate(QuestionTemplate questionTemplate) {
		this.questionTemplate = questionTemplate;
	}

	@SerializedName(ID)
	@DatabaseField(columnName = ID, generatedId = true)
	private int id;
	@SerializedName(OPTION)
	@DatabaseField(columnName = OPTION)
	private String option;
	@SerializedName(QUESTION_TEMPLATE)
	@DatabaseField(foreign = true, foreignColumnName = QuestionTemplate.ID, foreignAutoRefresh = true, columnName = QUESTION_TEMPLATE)
	private transient QuestionTemplate questionTemplate;
}
