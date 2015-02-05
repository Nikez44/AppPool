package com.community.survey;

import java.util.ArrayList;

import com.community.survey.models.Task;

import android.widget.ListView;
import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.survey_zone)
public class SurveyZoneActivity extends RoboFragmentActivity{
	
	public static final String TAG = SurveyZoneActivity.class.getSimpleName();
	
	@InjectView(R.id.ListSurveyZone)
	private ListView lvsurvey;
	
	
	
}
