package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.QuestionTemplate;
import com.community.survey.models.SurveyTemplate;
import com.community.survey.repository.interfaces.QuestionTemplateRepository;
import com.community.survey.repository.interfaces.SurveyTemplateRepository;

public class OrmliteSurveyTemplateRepository extends
		OrmliteBaseRepository<SurveyTemplate> implements
		SurveyTemplateRepository {

	public OrmliteSurveyTemplateRepository(OrmliteDatabaseHelper helper) {
		super(helper, SurveyTemplate.class);
		// TODO Auto-generated constructor stub
		mHelper = helper;
		initRepository();
	}

	@Override
	public int addObject(SurveyTemplate object) {
		// TODO Auto-generated method stub
		int created = 0;
		created += super.addObject(object);
		addQuestionTemplates(object);
		return created;

	}

	private void initRepository() {
		// TODO Auto-generated method stub
		mQuestionTemplateRepository = new OrmliteQuestionTemplateRepository(
				mHelper);
	}

	private void addQuestionTemplates(SurveyTemplate object) {
		// TODO Auto-generated method stub
		if (object != null && object.getQuestions() != null) {
			for (QuestionTemplate questionTemplate : object.getQuestions()) {
				mQuestionTemplateRepository.addObject(questionTemplate);
			}
		}
	}

	private OrmliteDatabaseHelper mHelper;
	private QuestionTemplateRepository mQuestionTemplateRepository;

}
