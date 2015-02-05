package com.community.survey;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.community.survey.controllers.QuestionsController;
import com.community.survey.controllers.SurveyController;
import com.community.survey.fragments.ApplyingSurveyFragment;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.QuestionTemplate;
import com.community.survey.models.QuestionType;
import com.community.survey.models.SurveyTemplate;
import com.community.survey.models.TaskType;
import com.google.inject.Inject;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;

@ContentView(R.layout.view_survey_layout)
public class ApplyingSurveyActivity extends RoboFragmentActivity {

	public static final String TAG = ApplyingSurveyActivity.class
			.getSimpleName();

	public static final String TASK_TYPE = "TaskType";
	public static final String TASK_ID = "TaskId";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();

		int taskId = intent.getIntExtra(TASK_ID, -1);
		TaskType taskType = (TaskType) intent.getSerializableExtra(TASK_TYPE);

		if (taskId == -1) {
			throw new IllegalArgumentException(
					"Can't open this activity without a Task Type and a Task Id");
		}

		addApplyingSurveyFragment();
	}

	public void replaceFragment(Fragment fragment, String tag,
			boolean addToBackstack) {
		FragmentManager fragMan = getSupportFragmentManager();
		FragmentTransaction fragTrans = fragMan.beginTransaction();
		fragTrans.replace(R.id.viewSurveyLayout_fragmentContainer, fragment,
				tag);

		if (addToBackstack) {
			fragTrans.addToBackStack(tag);
		}

		fragTrans.commit();
	}

	private void addApplyingSurveyFragment() {
		SurveyTemplate survey = getSurvey();
		ApplyingSurveyFragment fragment = ApplyingSurveyFragment
				.newInstance(survey.getQuestions());
		replaceFragment(fragment, ApplyingSurveyFragment.TAG, false);
	}	

	private void dummy() {
		SurveyTemplate surveyTemplate = new SurveyTemplate();
		for (int i = 0; i < 10; i++) {
			QuestionTemplate questionTemplate = new QuestionTemplate();
			questionTemplate.setId(i + 1);
			questionTemplate.setType(QuestionType.OPCION_MULTIPLE_PER);
			questionTemplate.setQuestion("Question " + (i + 1));
			questionTemplate.setSurveyTemplate(surveyTemplate);
			for (int j = 0; j < 3; j++) {
				QuestionOption questionOption = new QuestionOption();
				questionOption.setId(j + 1);
				questionOption.setOption("Option " + (j + 1));
				questionOption.setQuestionTemplate(questionTemplate);
				questionTemplate.addOption(questionOption);
			}
			surveyTemplate.addQuestion(questionTemplate);
		}
	}
	
	 private SurveyTemplate getSurvey(){	  
		   List<SurveyTemplate> srvLst = suvCtrl.getAll();
		   return srvLst.get(0);	   
	   }
	
	@Inject
	private SurveyController suvCtrl;

}
