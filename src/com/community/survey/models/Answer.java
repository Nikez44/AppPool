package com.community.survey.models;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Answer {

	public static final String ID = "Id";
	public static final String ANSWER = "Answer";
	public static final String QUESTION_TEMPLATE = "QuestionTemplate";
	public static final String APPLIED_SURVEY = "AppliedSurvey";

	public Answer() {
	}

	public Answer(String answer, QuestionTemplate question) {
		this.answer = answer;
		this.question = question;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof Answer) {
			Answer answer = (Answer) o;
			return answer.getId() == getId();
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionTemplate getQuestion() {
		return question;
	}

	public void setQuestion(QuestionTemplate template) {
		this.question = template;
	}

	public AppliedSurvey getAppliedSurvey() {
		return appliedSurvey;
	}

	public void setAppliedSurvey(AppliedSurvey appliedSurvey) {
		this.appliedSurvey = appliedSurvey;
	}

	@SerializedName(ID)
	@DatabaseField(columnName = ID, generatedId = true)
	private int id;
	@DatabaseField(columnName = ANSWER)
	private String answer;
	@DatabaseField(columnName = QUESTION_TEMPLATE, foreign = true, foreignColumnName = QuestionTemplate.ID)
	private QuestionTemplate question;
	@SerializedName(APPLIED_SURVEY)
	@DatabaseField(foreign = true, foreignColumnName = AppliedSurvey.ID, foreignAutoRefresh = true, columnName = APPLIED_SURVEY)
	private AppliedSurvey appliedSurvey;
}
