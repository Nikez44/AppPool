package com.community.survey;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@ContentView(R.layout.survey_menu)
public class SurveyActivity extends RoboFragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		btnCreateSurvey.setOnClickListener(mOnClickListener);
		btnViewSurveys.setOnClickListener(mOnClickListener);
	}

	private void showToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	private void openCreateSurveyActivity(){
		Intent intent = new Intent(this, CreateSurveyActivity.class);
		startActivity(intent);
	}
	
	private void openTaskView(){
    	Intent intent = new Intent(this, TaskViewActivity.class);
    	startActivity(intent);
    }

	private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int buttonId = v.getId();
			switch (buttonId) {
			case R.id.btnViewSurveys:
				openTaskView();
				break;
			case R.id.btnCreateSurvey:
				openCreateSurveyActivity();
				break;
			}			
		}
	};
	
	@InjectView(R.id.btnViewSurveys)
	private Button btnViewSurveys;
	@InjectView(R.id.btnCreateSurvey)
	private Button btnCreateSurvey;
}
