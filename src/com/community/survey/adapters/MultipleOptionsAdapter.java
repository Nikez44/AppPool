package com.community.survey.adapters;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

import com.community.survey.R;
import com.community.survey.models.QuestionOption;
import com.community.survey.viewholders.ViewHolderMultipleOptions;

public class MultipleOptionsAdapter extends ArrayAdapter<QuestionOption> {

	public static final String TAG = MultipleOptionsAdapter.class.getSimpleName();
	
	private Context context;
	private List<QuestionOption> datos;

	public MultipleOptionsAdapter(Context context, List<QuestionOption> objects) {
		super(context, R.layout.multiple_anwers_adapter_view, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.datos = objects;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View currentView = convertView;
		ViewHolderMultipleOptions holder;
		
		if(currentView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			currentView = inflater.inflate(R.layout.multiple_options_adapter, parent,false);			
			holder = new ViewHolderMultipleOptions();			
			holder.radioButton = (RadioButton) currentView.findViewById(R.id.radioButton1);			
			currentView.setTag(holder);
		}
		
		holder = (ViewHolderMultipleOptions) currentView.getTag();		
		QuestionOption option = datos.get(position);		
	    holder.radioButton.setText(option.getOption());	
	    
	    holder.radioButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mSelectedPosition = position;
				notifyDataSetChanged();
			}
		});
	    
	    holder.radioButton.setChecked(mSelectedPosition == position);
	    
		return currentView;		
	}
	
	private int mSelectedPosition;
}
