package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.AppliedSurvey;
import com.community.survey.repository.interfaces.AppliedSurveyRepository;

public class OrmliteAppliedSurveyRepository extends OrmliteBaseRepository<AppliedSurvey> implements AppliedSurveyRepository {

	public OrmliteAppliedSurveyRepository(OrmliteDatabaseHelper helper) {
		super(helper, AppliedSurvey.class);
		// TODO Auto-generated constructor stub
	}

}
