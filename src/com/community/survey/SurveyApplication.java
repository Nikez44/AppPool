package com.community.survey;

import roboguice.RoboGuice;
import android.app.Application;

public class SurveyApplication extends Application{
	
	public static final String TAG = SurveyApplication.class.getSimpleName();
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		RoboGuice.setUseAnnotationDatabases(false);
	}
}
