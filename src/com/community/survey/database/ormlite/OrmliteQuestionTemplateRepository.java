package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.QuestionTemplate;
import com.community.survey.repository.interfaces.QuestionOptionRepository;
import com.community.survey.repository.interfaces.QuestionTemplateRepository;

public class OrmliteQuestionTemplateRepository extends
		OrmliteBaseRepository<QuestionTemplate> implements
		QuestionTemplateRepository {

	public OrmliteQuestionTemplateRepository(OrmliteDatabaseHelper helper) {
		super(helper, QuestionTemplate.class);
		// TODO Auto-generated constructor stub
		mHelper = helper;
		initRepository();
	}

	@Override
	public int addObject(QuestionTemplate object) {
		// TODO Auto-generated method stub
		int created = 0;
		created += super.addObject(object);
		addQuestionOptions(object);
		return created;
	}

	private void initRepository() {
		// TODO Auto-generated method stub
		mQuestionOptionRepository = new OrmliteQuestionOptionRepository(mHelper);
	}

	private void addQuestionOptions(QuestionTemplate object) {
		// TODO Auto-generated method stub
		if (object != null && object.getOptions() != null) {
			for (QuestionOption option : object.getOptions()) {
				mQuestionOptionRepository.addObject(option);
			}
		}
	}

	private QuestionOptionRepository mQuestionOptionRepository;
	private OrmliteDatabaseHelper mHelper;

}
