package com.community.survey.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class SurveyTemplate {

	public static final String ID = "Id";
	public static final String QUESTION_TEMPLATES = "QuestionTemplates";

	public SurveyTemplate() {

	}
	
/*	public SurveyTemplate(int id){
		this.id=id;
	}
	*/

	public void addQuestion(QuestionTemplate question) {
		mayInitQuestionList();
		questions.add(question);
	}

	public void deleteQuestion(QuestionTemplate question) {
		if (questions != null && question != null) {
			questions.remove(question);
		}
	}

	public List<QuestionTemplate> getQuestions() {
		ArrayList<QuestionTemplate> list = new ArrayList<QuestionTemplate>();
		if (questions != null) {
			for (QuestionTemplate question : questions) {
				list.add(question);
			}
		}
		return list;
	}

	public void setQuestions(List<QuestionTemplate> questions) {
		this.questions = questions;
	}

	private void mayInitQuestionList() {
		if (questions == null) {
			questions = new ArrayList<QuestionTemplate>();
		}
	}

	@SerializedName(ID)
	@DatabaseField(columnName = ID, generatedId = true)
	private int id;
	@SerializedName(QUESTION_TEMPLATES)
	@ForeignCollectionField(eager = true)
	private Collection<QuestionTemplate> questions;
}
