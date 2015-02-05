package com.community.survey;

import java.util.ArrayList;

import com.community.survey.adapters.TaskAdapter;
import com.community.survey.models.Task;
import com.community.survey.models.TaskType;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.task_activity_view)
public class TaskViewActivity extends RoboFragmentActivity{
	
	public static final String TAG = TaskViewActivity.class.getSimpleName();
	
	@InjectView(R.id.ListViewTask)
	private ListView lvTask;
	
	private ArrayList<Task> Tasks;
	private TaskAdapter aadapter;
	private OnItemClickListener clickListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Tasks = new ArrayList<Task>();
		
		aadapter = new TaskAdapter(this.getApplicationContext(), Tasks);
		
		lvTask.setAdapter(aadapter);	
		
		clickListener = new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Task task= (Task) lvTask.getAdapter().getItem(position);
				
				switch(task.getTaskType()){
				case SOCIAL:
										
					break;
				case SURVEY:
					openVideoViewActivity(task);
					//openViewSurveyActivity(task);
					break;
				case MEETING:
					
					break;
				}

			}
		};
		
		lvTask.setOnItemClickListener(clickListener);
		
		InitializeTaskData();
	}
	
    private void openVideoViewActivity(Task task){
    	Intent intent = new Intent(this, VideoViewActivity.class);
    	intent.putExtra("TaskType", task.getTaskType());
    	intent.putExtra("TaskId",task.getId());
    	startActivity(intent);
    }
	
    /*
    private void openViewSurveyActivity(Task task){
    	Intent intent = new Intent(this, ApplyingSurveyActivity.class);
    	intent.putExtra(ApplyingSurveyActivity.TASK_TYPE, task.getTaskType());
    	intent.putExtra(ApplyingSurveyActivity.TASK_ID,task.getId());
    	startActivity(intent);
    }*/
	
	//Here is where we grab the activities on the DB and put them in the Array for the view
	private void InitializeTaskData(){
		
		Task t= new Task();
		
		t.setName("Task activity");
		t.setDescription("Hey im a description");
		t.setId(1);
		t.setTaskType(TaskType.SURVEY);
		
		Task e = new Task();
		e.setName("Task activity2");
		e.setDescription("Im just another description and i dont do anything but i work");
		e.setTaskType(TaskType.SOCIAL);
		Tasks.add(t);
		Tasks.add(e);
		
		aadapter.notifyDataSetChanged();
	}	
	
}
