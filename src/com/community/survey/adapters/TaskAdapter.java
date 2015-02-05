package com.community.survey.adapters;

import java.util.ArrayList;
import java.util.List;

import com.community.survey.R;
import com.community.survey.models.Task;
import com.community.survey.models.User;
import com.community.survey.viewholders.ViewHolderTask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<Task>{
	private Context context;
	private List<Task> datos;
	
	public TaskAdapter(Context context, ArrayList<Task> objects) {
		super(context,R.layout.adapter_view, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.datos = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View  currentView = convertView;
		ViewHolderTask holder;
		
		if(currentView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			currentView = inflater.inflate(R.layout.adapter_view, parent,false);			
			holder = new ViewHolderTask();			
			holder.title = (TextView) currentView.findViewById(R.id.tvTitle);
			holder.description = (TextView) currentView.findViewById(R.id.tvContent);			
			currentView.setTag(holder);
		}
		
		holder = (ViewHolderTask) currentView.getTag();		
		Task task = datos.get(position);		
	    holder.title.setText(task.getName());
	    holder.description.setText(task.getDescription());		
	    return currentView;
	}
}
