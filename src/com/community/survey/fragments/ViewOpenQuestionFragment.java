package com.community.survey.fragments;

import java.util.List;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.community.survey.R;
import com.community.survey.controllers.AnswerController;
import com.community.survey.models.Answer;
import com.community.survey.models.QuestionTemplate;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class ViewOpenQuestionFragment extends RoboFragment {

	public static final String TAG = ViewOpenQuestionFragment.class
			.getSimpleName();
	private QuestionTemplate qt;
	private List<Answer> answers;
	private int myPossition;

	@InjectView(R.id.viewOpenQuestionFragment_textViewQuestion)
	private TextView tvQuestion;
	@InjectView(R.id.viewOpenQuestionFragment_editTextAnswer)
	private EditText etAnswer;
	
	private AnswerController mAnswerController;

	public static ViewOpenQuestionFragment newInstance(int myPossition,
			QuestionTemplate qt, List<Answer> answers) {
		ViewOpenQuestionFragment fragment = new ViewOpenQuestionFragment();
		fragment.qt = qt;
		fragment.answers = answers;
		fragment.myPossition = myPossition;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.view_open_question_fragment,
				container, false);
	}

	@Override
	public void onPause() {
		super.onPause();
		Answer answer = retrieveAnswersFromView();
		//mAnswerController.addAnswer(answer);
		//mAnswerController.retrieve
		answers.set(myPossition, answer);
	}

	private Answer retrieveAnswersFromView() {
		String selectedAnswer = etAnswer.getText().toString();		
		Answer answer = new Answer(selectedAnswer, qt);
		return answer;
	}		

	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();		
		tvQuestion.setText(qt.getQuestion());
			
	}

}
