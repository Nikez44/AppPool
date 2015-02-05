package com.community.survey.fragments;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.Toast;

import com.community.survey.models.Answer;
import com.community.survey.models.QuestionTemplate;

public class ViewPagerAdapter extends FragmentStatePagerAdapter implements OnPageChangeListener{

	private List<Fragment> fragments;
	private List<Answer> answers=new ArrayList<Answer>();

	public ViewPagerAdapter(FragmentManager fm, List<QuestionTemplate> questions) {
		super(fm);
		// TODO Auto-generated constructor stub
		
		List<Fragment> fragments = new ArrayList<Fragment>();
		
        int position=0;
		for (QuestionTemplate qt : questions) {
			String ans="Hola";
			Answer answer = new Answer(ans, questions.get(1));
			answers.add(answer);
			switch (qt.getType()) {
			case OPCION_MULTIPLE_RESP:
				fragments.add(ViewMultipleAnswersFragment.newInstance(qt));
				break;
			case OPCION_MULTIPLE_PER:
				fragments.add(ViewMultipleOptionsFragment.newInstance(qt));
				break;
			case ABIERTA:
				fragments.add(ViewOpenQuestionFragment.newInstance(position,qt,answers));
				break;
			default:
				break;
			}
			position++;
		}
		
		fragments.add(ViewEndSurveyFragment.newInstance(answers));
		
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		
		return this.fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.fragments.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		if((position+1) != fragments.size()){
			return "Pregunta " + (position+1);
		}
		return "Terminar";
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
