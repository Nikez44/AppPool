package com.community.survey.fragments;

import roboguice.fragment.RoboFragment;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.community.survey.R;
import com.community.survey.controllers.SurveyController;
import com.community.survey.models.SurveyTemplate;
import com.google.inject.Inject;

@ContentView(R.layout.create_survey_fragment)
public class CreateSurveyFragment extends RoboFragment{
	
	public static final String TAG = CreateSurveyFragment.class.getSimpleName();
	
	public static CreateSurveyFragment newInstance(){
		return new CreateSurveyFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.create_survey_fragment, container, false);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		populateView();
		
		SurveyTemplate template = new SurveyTemplate();
		mSurveyController.addSurvey(template);
	}
	
	private void populateView(){
		btnAddQuestion.setOnClickListener(mOnClickListener);
		aaQuestionTypes = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, opcQuestionTypes);
		spQuestionTypes.setAdapter(aaQuestionTypes);
	}
	
	public void btnAddQuestionOnClick(){		
		int selected = spQuestionTypes.getSelectedItemPosition();
		switch (selected) {
		case 0:
			showToast("Abierta");
			break;
		case 1:					
//			Fragment options = new MultipleOptionsFragment(etQuestion.getText().toString());					
//			getFragmentManager().beginTransaction()
//			.replace(R.id.fragment_container, options).addToBackStack(null).commit();			
			break;
		case 2:
			showToast("Sino");
			break;
		}
	}
	
	private void showToast(String msg) {
		Toast t = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
		t.show();
	}

	
	private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnAddQuestion:
				btnAddQuestionOnClick();
				break;
			}
			
		}
	};
	
	@InjectView(R.id.btnAddQuestion)
	private Button btnAddQuestion;
	@InjectView(R.id.etQuestion)
	private EditText etQuestion;
	@InjectView(R.id.spQuestionTypes)
	private Spinner spQuestionTypes;
	@Inject
	private SurveyController mSurveyController;
	
	private ArrayAdapter<String> aaQuestionTypes;
	private String[] opcQuestionTypes = new String[] { "Abierta", "Opcion", "Sino" };
}
