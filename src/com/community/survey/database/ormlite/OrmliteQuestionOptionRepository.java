package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.QuestionOption;
import com.community.survey.repository.interfaces.QuestionOptionRepository;

public class OrmliteQuestionOptionRepository extends OrmliteBaseRepository<QuestionOption> implements QuestionOptionRepository{

	public OrmliteQuestionOptionRepository(OrmliteDatabaseHelper helper) {
		super(helper, QuestionOption.class);
		// TODO Auto-generated constructor stub
	}

}
