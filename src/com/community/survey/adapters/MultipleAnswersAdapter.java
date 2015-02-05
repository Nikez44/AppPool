package com.community.survey.adapters;

import java.util.List;

import com.community.survey.R;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.Task;
import com.community.survey.viewholders.ViewHolderMultipleAnswers;
import com.community.survey.viewholders.ViewHolderSurvey;
import com.community.survey.viewholders.ViewHolderTask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MultipleAnswersAdapter extends ArrayAdapter<QuestionOption> {

	private Context context;
	private List<QuestionOption> datos;

	public MultipleAnswersAdapter(Context context, List<QuestionOption> objects) {
		super(context, R.layout.multiple_anwers_adapter_view, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.datos = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View currentView = convertView;
		ViewHolderMultipleAnswers holder;
		
		if(currentView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			currentView = inflater.inflate(R.layout.multiple_anwers_adapter_view, parent,false);			
			holder = new ViewHolderMultipleAnswers();			
			holder.checkbox = (CheckBox) currentView.findViewById(R.id.checkBoxOption);			
			currentView.setTag(holder);
		}
		
		holder = (ViewHolderMultipleAnswers) currentView.getTag();		
		QuestionOption option = datos.get(position);		
	    holder.checkbox.setText(option.getOption());	
	    
		return currentView;		
	}

}
