package com.community.survey.fragments;

import java.util.List;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.community.survey.R;
import com.community.survey.controllers.AnswerController;
import com.community.survey.models.Answer;

public class ViewEndSurveyFragment extends RoboFragment {

	public static final String TAG = ViewEndSurveyFragment.class.getSimpleName();

	@InjectView(R.id.endSurveyFragment_ButtonSave)
	private Button mSaveButton;	
	private List<Answer> answers;	
	
	public static ViewEndSurveyFragment newInstance(List<Answer> answers){
		ViewEndSurveyFragment fragment= new ViewEndSurveyFragment();
		fragment.answers = answers;
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.end_survey, container, false);
	}
	
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		mSaveButton.setOnClickListener(mOnClickListener);				
	}
	
private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub			
			Toast.makeText(getActivity(), answers.get(2).getAnswer(), Toast.LENGTH_SHORT).show();
		}
	};
	
}
