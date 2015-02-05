package com.community.survey.fragments;

import com.community.survey.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class OpenQuestionFragment extends RoboFragment {

	public static final String TAG = OpenQuestionFragment.class.getSimpleName();

	public static OpenQuestionFragment newInstance() {
		return new OpenQuestionFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.open_question_fragment, container,
				false);
	}

	@InjectView(R.id.openQuestionFragment_editText)
	private EditText mAnswerEditTextView;

}
