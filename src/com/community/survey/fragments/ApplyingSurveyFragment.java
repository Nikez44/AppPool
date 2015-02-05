package com.community.survey.fragments;

import java.util.List;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.community.survey.ApplyingSurveyActivity;
import com.community.survey.R;
import com.community.survey.models.QuestionTemplate;

public class ApplyingSurveyFragment extends RoboFragment {

	public static final String TAG = ApplyingSurveyFragment.class
			.getSimpleName();

	private ViewPagerAdapter mPagerAdapter;
	@InjectView(R.id.applyingSurveyFragment_fragmentContainerViewPager)
	private ViewPager pager;

	private List<QuestionTemplate> questions;

	public static ApplyingSurveyFragment newInstance(
			List<QuestionTemplate> questions) {
		ApplyingSurveyFragment fragment = new ApplyingSurveyFragment();
		fragment.questions = questions;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.applying_survey_fragment, container,
				false);
	}

	private void initialisePaging() {
		// TODO Auto-generated method stub
		mPagerAdapter = new ViewPagerAdapter(this.getFragmentManager(),
				questions);
		pager.setAdapter(mPagerAdapter);			
	}	

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if (activity instanceof ApplyingSurveyActivity) {
		} else {
			throw new IllegalArgumentException(
					"Attaching Activity must be an instance of ViewSurveyActivity");
		}
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		initialisePaging();		
	}

}
