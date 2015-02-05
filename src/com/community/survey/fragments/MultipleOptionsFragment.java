package com.community.survey.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.community.survey.R;
import com.community.survey.R.id;
import com.community.survey.R.layout;

public class MultipleOptionsFragment extends Fragment implements
		OnClickListener {

	private EditText etAddOptions;
	private EditText etQuestion2;
	private Button btnOk;
	private Button btnSave;
	private ListView lvOptions;
	private ArrayList<String> Options;
	private ArrayAdapter<String> aaOptions;

	private String questionText;

	public MultipleOptionsFragment(String msg) {
		questionText = msg;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.multiple_options_fragment,
				container, false);

		etAddOptions = (EditText) rootView.findViewById(R.id.etAddOptions);
		etQuestion2 = (EditText) rootView.findViewById(R.id.etQuestion2);
		etQuestion2.setText(questionText);
		btnOk = (Button) rootView.findViewById(R.id.btnOK);
		btnOk.setOnClickListener(this);
		btnSave = (Button) rootView.findViewById(R.id.btnSave);
		btnSave.setOnClickListener(this);
		lvOptions = (ListView) rootView.findViewById(R.id.lvOptions);
		Options = new ArrayList<String>();
		aaOptions = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Options);
		lvOptions.setAdapter(aaOptions);

		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnOK:
			Options.add(etAddOptions.getText().toString());
			etAddOptions.setText("");
			aaOptions.notifyDataSetChanged();
			break;
		case R.id.btnSave:
			
			break;
		}

	}

}
