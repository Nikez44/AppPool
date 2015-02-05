package com.community.survey.fragments;

import com.community.survey.CreateSurveyActivity;
import com.community.survey.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class SurveySummaryFragment extends RoboFragment{
	
	public static final String TAG = SurveySummaryFragment.class.getSimpleName();
	
	public static SurveySummaryFragment newInstance(){
		return new SurveySummaryFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.create_survey_summary_list_layout, container, false);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if(activity instanceof CreateSurveyActivity){
			mCreateSurveyActivity = (CreateSurveyActivity)activity;
		}else{
			throw new IllegalArgumentException("Attaching Activity must be an instance of CreateSurveyActivity");
		}
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		initButtons();
	}
	
	private void initButtons(){
		mAddQuestionButton.setOnClickListener(mOnClickListener);
		mCreateSurveyButton.setOnClickListener(mOnClickListener);
	}
	
	private void createSurvey(){
		
	}
	
	private void addQuestionToSurvey(){
		CreateSurveyFragment fragment = CreateSurveyFragment.newInstance();
		mCreateSurveyActivity.replaceFragment(fragment, CreateSurveyFragment.TAG, true);
	}
	
	private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			switch(id){
			case R.id.createSurveySummary_createSurveyButton:
				createSurvey();
				break;
			case R.id.createSurveySummary_addQuestionButton:
				addQuestionToSurvey();
				break;
			}
		}
	};
	
	private CreateSurveyActivity mCreateSurveyActivity;
	
	@InjectView(R.id.createSurveySummary_addQuestionButton)
	private Button mAddQuestionButton;
	@InjectView(R.id.createSurveySummary_createSurveyButton)
	private Button mCreateSurveyButton;
	@InjectView(R.id.createSurveySummary_mainList)
	private ListView mQuestionList;
}
