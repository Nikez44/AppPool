package com.community.survey.fragments;

import java.util.ArrayList;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.community.survey.R;
import com.community.survey.adapters.MultipleAnswersAdapter;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.QuestionTemplate;

public class ViewMultipleAnswersFragment extends RoboFragment {

	public static final String TAG = ViewMultipleAnswersFragment.class.getSimpleName();

	@InjectView(R.id.viewMultipleAnswersFragment_listViewOptions)
	private ListView lvOptions;
	@InjectView(R.id.viewMultipleAnswers_textViewQuestion)
	private TextView tvQuestion;
	
	private ArrayList<QuestionOption> options;
	private MultipleAnswersAdapter opsAdapter;
	private QuestionTemplate qt;	

	public static ViewMultipleAnswersFragment newInstance(QuestionTemplate qt) {
		ViewMultipleAnswersFragment fragment = new ViewMultipleAnswersFragment();
		fragment.qt = qt;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.view_multipleanswers_fragment, container, false);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();		
		options = new ArrayList<QuestionOption>();
		opsAdapter = new MultipleAnswersAdapter(getActivity(), options);
		lvOptions.setAdapter(opsAdapter);
		lvOptions.setOnItemClickListener(mClickListener);
		
		options.addAll(qt.getOptions());		
		opsAdapter.notifyDataSetChanged();
		tvQuestion.setText(qt.getQuestion());				
	}	
	
	private OnItemClickListener mClickListener = new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {			
			//QuestionOption option= (QuestionOption) lvOptions.getAdapter().getItem(position);			
		}
	};

}
