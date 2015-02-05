package com.community.survey.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class QuestionTemplate {

	public static final String ID = "Id";
	public static final String QUESTION = "Question";
	public static final String QUESTION_TYPE = "QuestionType";
	public static final String QUESTION_OPTIONS = "QuestionOptions";
	public static final String SURVEY_TEMPLATE = "SurveyTemplate";

	public QuestionTemplate() {
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o instanceof QuestionTemplate) {
			QuestionTemplate questionTemplate = (QuestionTemplate) o;
			return questionTemplate.getId() == getId();
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public List<QuestionOption> getOptions() {
		ArrayList<QuestionOption> list = new ArrayList<QuestionOption>();
		if (options != null) {
			for (QuestionOption option : options) {
				list.add(option);
			}
		}
		return list;
	}

	public void addOption(QuestionOption option) {
		mayInitQuestionOptionList();
		this.options.add(option);
	}

	public void setOptions(List<QuestionOption> options) {
		this.options = options;
		if (this.options != null) {
			for (QuestionOption option : this.options) {
				option.setQuestionTemplate(this);
			}
		}
	}

	public void deleteOption(QuestionOption option) {
		if (this.options != null && option != null) {
			this.options.remove(option);
		}
	}

	private void mayInitQuestionOptionList() {
		if (this.options == null) {
			this.options = new ArrayList<QuestionOption>();
		}
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
	}

	public void setSurveyTemplate(SurveyTemplate surveyTemplate) {
		this.surveyTemplate = surveyTemplate;
	}

	@DatabaseField(columnName = ID, generatedId = true)
	@SerializedName(ID)
	private int id;
	@DatabaseField(columnName = QUESTION)
	@SerializedName(QUESTION)
	private String question;
	@DatabaseField(columnName = QUESTION_TYPE, dataType = DataType.ENUM_INTEGER)
	@SerializedName(QUESTION_TYPE)
	private QuestionType type;
	@SerializedName(QUESTION_OPTIONS)
	@ForeignCollectionField(eager = true)
	private Collection<QuestionOption> options;
	@SerializedName(SURVEY_TEMPLATE)
	@DatabaseField(foreign = true, foreignColumnName = SurveyTemplate.ID, foreignAutoRefresh = true, columnName = SURVEY_TEMPLATE)
	private transient SurveyTemplate surveyTemplate;
}
