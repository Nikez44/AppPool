package com.community.survey.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.community.survey.R;
import com.community.survey.adapters.MultipleOptionsAdapter;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.QuestionTemplate;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class ViewMultipleOptionsFragment extends RoboFragment {

	public static final String TAG = ViewMultipleOptionsFragment.class.getSimpleName();

	@InjectView(R.id.viewMultipleOptionsFragment_listViewOptions)
	private ListView lvOptions;
	@InjectView(R.id.viewMultipleOptionsFragment_textViewQuestion)
	private TextView tvQuestion;
	
	private ArrayList<QuestionOption> options;
	private MultipleOptionsAdapter opsAdapter;
	private QuestionTemplate qt;	

	public static ViewMultipleOptionsFragment newInstance(QuestionTemplate qt) {
		ViewMultipleOptionsFragment fragment = new ViewMultipleOptionsFragment();
		fragment.qt = qt;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.view_multiple_options_fragment, container, false);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();		
		options = new ArrayList<QuestionOption>();
		opsAdapter = new MultipleOptionsAdapter(getActivity(), options);
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
