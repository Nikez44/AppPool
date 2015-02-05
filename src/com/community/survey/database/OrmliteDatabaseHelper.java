package com.community.survey.database;

import roboguice.inject.ContextSingleton;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.community.survey.models.Answer;
import com.community.survey.models.AppliedSurvey;
import com.community.survey.models.Binnacle;
import com.community.survey.models.Location;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.QuestionTemplate;
import com.community.survey.models.Section;
import com.community.survey.models.SocialToken;
import com.community.survey.models.SurveyTemplate;
import com.community.survey.models.Task;
import com.community.survey.models.User;
import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

@ContextSingleton
public class OrmliteDatabaseHelper extends OrmLiteSqliteOpenHelper{

	@Inject
	public OrmliteDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {
		// TODO Auto-generated method stub
		for(Class<?> currentClass : mDbClasses){
			try{
				TableUtils.createTableIfNotExists(connectionSource, currentClass);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	private static Class<?>[] mDbClasses = {
		Answer.class,
		AppliedSurvey.class,
		Binnacle.class,
		Location.class,
		QuestionOption.class,
		QuestionTemplate.class,
		Section.class,
		SocialToken.class,
		SurveyTemplate.class,
		Task.class,
		User.class
	};
	
	private static final String DATABASE_NAME = "SurveyApp.db";
	private static final int DATABASE_VERSION = 1;
}
