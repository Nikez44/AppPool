package com.community.survey.modules;

import android.app.Application;
import android.content.Context;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.database.ormlite.OrmliteAnswerRepository;
import com.community.survey.database.ormlite.OrmliteAppliedSurveyRepository;
import com.community.survey.database.ormlite.OrmliteBinnacleRepository;
import com.community.survey.database.ormlite.OrmliteLocationRepository;
import com.community.survey.database.ormlite.OrmliteQuestionOptionRepository;
import com.community.survey.database.ormlite.OrmliteQuestionTemplateRepository;
import com.community.survey.database.ormlite.OrmliteSectionRepository;
import com.community.survey.database.ormlite.OrmliteSocialTokenRepository;
import com.community.survey.database.ormlite.OrmliteSurveyTemplateRepository;
import com.community.survey.database.ormlite.OrmliteTaskRepository;
import com.community.survey.database.ormlite.OrmliteUserRepository;
import com.community.survey.repository.interfaces.AnswerRepository;
import com.community.survey.repository.interfaces.AppliedSurveyRepository;
import com.community.survey.repository.interfaces.BinnacleRepository;
import com.community.survey.repository.interfaces.LocationRepository;
import com.community.survey.repository.interfaces.QuestionOptionRepository;
import com.community.survey.repository.interfaces.QuestionTemplateRepository;
import com.community.survey.repository.interfaces.SectionRepository;
import com.community.survey.repository.interfaces.SocialTokenRepository;
import com.community.survey.repository.interfaces.SurveyTemplateRepository;
import com.community.survey.repository.interfaces.TaskRepository;
import com.community.survey.repository.interfaces.UserRepository;
import com.google.inject.AbstractModule;

public class OrmliteModule extends AbstractModule{
	
	public OrmliteModule(Application application){
		mContext = application;
	}
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		OrmliteDatabaseHelper helper = new OrmliteDatabaseHelper(mContext);
		
		bind(AnswerRepository.class).toInstance(new OrmliteAnswerRepository(helper));
		bind(AppliedSurveyRepository.class).toInstance(new OrmliteAppliedSurveyRepository(helper));
		bind(BinnacleRepository.class).toInstance(new OrmliteBinnacleRepository(helper));
		bind(LocationRepository.class).toInstance(new OrmliteLocationRepository(helper));
		bind(QuestionOptionRepository.class).toInstance(new OrmliteQuestionOptionRepository(helper));
		bind(QuestionTemplateRepository.class).toInstance(new OrmliteQuestionTemplateRepository(helper));
		bind(SectionRepository.class).toInstance(new OrmliteSectionRepository(helper));
		bind(SocialTokenRepository.class).toInstance(new OrmliteSocialTokenRepository(helper));
		bind(SurveyTemplateRepository.class).toInstance(new OrmliteSurveyTemplateRepository(helper));
		bind(TaskRepository.class).toInstance(new OrmliteTaskRepository(helper));
		bind(UserRepository.class).toInstance(new OrmliteUserRepository(helper));
		
	}

	private Context mContext;
}
