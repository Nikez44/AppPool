package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.Answer;
import com.community.survey.repository.interfaces.AnswerRepository;
import com.google.inject.Inject;

public class OrmliteAnswerRepository extends OrmliteBaseRepository<Answer> implements AnswerRepository {

	@Inject
	public OrmliteAnswerRepository(OrmliteDatabaseHelper helper) {
		super(helper, Answer.class);
		// TODO Auto-generated constructor stub
	}
	
}
