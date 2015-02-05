package com.community.survey.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.community.survey.R;

import roboguice.fragment.RoboFragment;

public class ViewSurveyFragment extends RoboFragment{

	public static final String TAG = ViewSurveyFragment.class.getSimpleName();
	
	public static ViewSurveyFragment newInstance(){
		return new ViewSurveyFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.view_multiple_options_fragment, container, false);
	}
	
}
