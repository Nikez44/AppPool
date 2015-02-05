package com.community.survey.adapters;

import java.util.ArrayList;
import java.util.List;

import com.community.survey.R;
import com.community.survey.models.SurveyTemplate;
import com.community.survey.models.Task;
import com.community.survey.viewholders.ViewHolderSurvey;
import com.community.survey.viewholders.ViewHolderTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SurveyAdapter extends ArrayAdapter<SurveyTemplate>{
	private Context context;
	private List<SurveyTemplate> datos;

	public SurveyAdapter(Context context, ArrayList<SurveyTemplate> objects) {
		super(context,R.layout.adapter_view, objects);
		
		this.context = context;
		this.datos = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		View  currentView = convertView;
		ViewHolderSurvey holder;
		
		if(currentView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			currentView = inflater.inflate(R.layout.adapter_view, parent,false);			
			holder = new ViewHolderSurvey();			
			holder.title = (TextView) currentView.findViewById(R.id.tvTitle);
			holder.description = (TextView) currentView.findViewById(R.id.tvContent);			
			currentView.setTag(holder);
		}
		
		holder = (ViewHolderSurvey) currentView.getTag();
		SurveyTemplate template= datos.get(position);
		
		//Aun falta definir mas
	    //nombre.setText(template.);


	    //numCelda.setText(template.getDescription());
		
	    return currentView;
	}
	
}
