package com.community.survey;

import com.community.survey.fragments.CreateSurveyFragment;
import com.community.survey.fragments.SurveySummaryFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;

@ContentView(R.layout.create_survey_layout)
public class CreateSurveyActivity extends RoboFragmentActivity {
	
	public static final String TAG = CreateSurveyActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addSurveySummaryFragment();
	}
	
	public void replaceFragment(Fragment fragment, String tag, boolean addToBackstack){
		FragmentManager fragMan = getSupportFragmentManager();
		FragmentTransaction fragTrans = fragMan.beginTransaction();
		fragTrans.replace(R.id.createSurveyLayout_fragmentContainer, fragment, tag);
		
		if(addToBackstack){
			fragTrans.addToBackStack(tag);
		}
		
		fragTrans.commit();
	}
	
	private void addSurveySummaryFragment(){
		SurveySummaryFragment fragment = SurveySummaryFragment.newInstance();
		replaceFragment(fragment, CreateSurveyFragment.TAG, false);
	}
	
}
