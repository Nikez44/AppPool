package com.community.survey;

import java.io.File;

import com.community.survey.models.TaskType;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.video_view) 
public class VideoViewActivity extends RoboFragmentActivity{
	
	public static final String TAG = VideoViewActivity.class.getSimpleName();
	
	@InjectView(R.id.Videoview)
	private VideoView mvideo;
	
	private String SrcPath;
	private int taskId;
	private TaskType taskType;
	
	private int stopPosition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		
		super.onCreate(savedInstanceState);
		
		if( savedInstanceState != null ) {
	        stopPosition = savedInstanceState.getInt("position");
	    }
		
		getDataInIntent(this.getIntent());
	
		setContentView(R.layout.video_view);
		
		mvideo.setOnCompletionListener(complete);
		
		setVideo();
		startVideo();
	}
	
	public void getDataInIntent(Intent intent){
		taskId = intent.getIntExtra("TaskId", -1);
		taskType = (TaskType) intent.getSerializableExtra("TaskType");
	}

	
	public void setVideo(){
		
		File extStorage = Environment.getExternalStorageDirectory();
		File videoFile = new File(extStorage, "Prueba.mp4");
		
		if(videoFile.exists()){
			Log.i("Exists","Exists");
		}
		
		
		mvideo.setVideoURI(Uri.parse(videoFile.getAbsolutePath()));
		mvideo.setMediaController(new MediaController(this));
		mvideo.requestFocus();
	}
	
	public void startVideo(){
		mvideo.start();
	}
	
	private void openAplyingSurvey(){
		Intent intent = new Intent(this, ApplyingSurveyActivity.class);
    	intent.putExtra(ApplyingSurveyActivity.TASK_TYPE, taskType );
    	intent.putExtra(ApplyingSurveyActivity.TASK_ID, taskId);
    	startActivity(intent);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    stopPosition = mvideo.getCurrentPosition(); 
	    mvideo.pause();
	    outState.putInt("position", stopPosition);
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    Log.d(TAG, "onResume called");
	    mvideo.seekTo(stopPosition);
	    mvideo.start(); //Or use resume() if it doesn't work. I'm not sure
	}
	
	private OnCompletionListener complete = new OnCompletionListener() {

		@Override
		public void onCompletion(MediaPlayer mp) {
			// TODO Auto-generated method stub
			//showToast("Finish");
			openAplyingSurvey();
		}
    };
	
}
