package com.community.survey.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class AppliedSurvey {

	public static final String ID = "Id";
	public static final String LOCATION = "Location";
	public static final String HOUSE_NUMBER = "HouseNumber";
	public static final String ANSWERS = "Answers";
	public static final String INTERVIEWED_PERSON = "InterviewedPerson";
	public static final String SURVEY_TEMPLATE = "SurveyTemplate";

	public AppliedSurvey() {
	}

	public AppliedSurvey(Location location, String houseNumber,
			String interviewedPerson, SurveyTemplate survey) {
		this.location = location;
		this.houseNumber = houseNumber;
		this.interviewedPerson = interviewedPerson;
		this.templateSurvey = survey;
		this.answers = new ArrayList<Answer>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public List<Answer> getAnswers() {
		ArrayList<Answer> list = new ArrayList<Answer>();
		if (answers != null) {
			for (Answer answer : answers) {
				list.add(answer);
			}
		}
		return list;
	}

	public void setAnswers(List<Answer> answers) {
		mayInitAnswerList();
		this.answers = answers;
	}

	public void removeAnswer(Answer answer) {
		if (answers != null) {
			answers.remove(answer);
		}
	}

	public String getInterviewedPerson() {
		return interviewedPerson;
	}

	public void setInterviewedPerson(String interviewedPerson) {
		this.interviewedPerson = interviewedPerson;
	}

	public SurveyTemplate getTemplateSurvey() {
		return templateSurvey;
	}

	public void setTemplateSurvey(SurveyTemplate templateSurvey) {
		this.templateSurvey = templateSurvey;
	}

	private void mayInitAnswerList() {
		if (this.answers == null) {
			this.answers = new ArrayList<Answer>();
		}
	}

	@DatabaseField(columnName = ID, generatedId = true)
	@SerializedName(ID)
	private int id;
	@DatabaseField(columnName = LOCATION, foreign = true, foreignColumnName = Location.ID)
	@SerializedName(LOCATION)
	private Location location;
	@DatabaseField(columnName = HOUSE_NUMBER)
	@SerializedName(HOUSE_NUMBER)
	private String houseNumber;
	@ForeignCollectionField(eager = true)
	@SerializedName(ANSWERS)
	private Collection<Answer> answers;
	@DatabaseField(columnName = INTERVIEWED_PERSON)
	@SerializedName(INTERVIEWED_PERSON)
	private String interviewedPerson;
	@DatabaseField(columnName = SURVEY_TEMPLATE, foreign = true, foreignColumnName = SurveyTemplate.ID)
	@SerializedName(SURVEY_TEMPLATE)
	private SurveyTemplate templateSurvey;

}
