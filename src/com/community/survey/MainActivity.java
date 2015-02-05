package com.community.survey;

import java.util.List;
import java.util.Random;

import com.community.survey.controllers.SurveyController;
import com.community.survey.fragments.ApplyingSurveyFragment;
import com.community.survey.fragments.MainFragment;
import com.community.survey.models.QuestionOption;
import com.community.survey.models.QuestionTemplate;
import com.community.survey.models.QuestionType;
import com.community.survey.models.SurveyTemplate;
import com.google.inject.Inject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;



import roboguice.activity.RoboFragmentActivity;


public class MainActivity extends RoboFragmentActivity {
	
	public static final String TAG = MainActivity.class.getSimpleName();
	
	@Inject
	private SurveyController suvCtrl;
	
	private MainFragment mMainFragment;	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SurveyTemplate srv = initializeOptionData();
        
        //Comment just for push, delete this comment
        
        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            mMainFragment = new MainFragment();
            getSupportFragmentManager()
            .beginTransaction()
            .add(android.R.id.content, mMainFragment)
            .commit();
        } else {
            // Or set the fragment from restored state info
            mMainFragment = (MainFragment) getSupportFragmentManager()
            .findFragmentById(android.R.id.content);
        }
        
    }
    
    private SurveyTemplate initializeOptionData() {    	
    	
		SurveyTemplate survey = new SurveyTemplate();

		QuestionTemplate qt = new QuestionTemplate();
		qt.setQuestion("Que opinaaaaa de Peña Nieto?");
		qt.setSurveyTemplate(survey);

		QuestionOption bueno = new QuestionOption();
		bueno.setOption("Bueno");
		bueno.setQuestionTemplate(qt);

		QuestionOption malo = new QuestionOption();
		malo.setOption("Malo");
		malo.setQuestionTemplate(qt);

		QuestionOption regular = new QuestionOption();
		regular.setOption("Regular");
		regular.setQuestionTemplate(qt);

		QuestionOption pendejo = new QuestionOption();
		pendejo.setOption("Pendejo");
		pendejo.setQuestionTemplate(qt);

		QuestionTemplate qt2 = new QuestionTemplate();
		qt2.setQuestion("Que opinas de Ayotzinapa?");
		qt2.setSurveyTemplate(survey);
		
		QuestionOption vale = new QuestionOption();
		vale.setOption("No me interesa");
		vale.setQuestionTemplate(qt2);

		QuestionOption crunch = new QuestionOption();
		crunch.setOption("Les dieron crunch");
		crunch.setQuestionTemplate(qt2);
		
		QuestionOption pobres = new QuestionOption();
		pobres.setOption("Pobrecillos");
		pobres.setQuestionTemplate(qt2);
		
		QuestionOption maldito = new QuestionOption();
		maldito.setOption("Maldito Gobierno");
		maldito.setQuestionTemplate(qt2);

		QuestionOption mala = new QuestionOption();
		mala.setOption("Que mala onda");
		mala.setQuestionTemplate(qt2);

		QuestionTemplate qt3 = new QuestionTemplate();
		qt3.setQuestion("Ola k ace?");
		qt3.setSurveyTemplate(survey);
		qt3.setType(QuestionType.ABIERTA);

		qt2.addOption(vale);
		qt2.addOption(crunch);
		qt2.addOption(pobres);
		qt2.addOption(maldito);
		qt2.addOption(mala);
		qt2.setType(QuestionType.OPCION_MULTIPLE_PER);

		qt.addOption(bueno);
		qt.addOption(malo);
		qt.addOption(regular);
		qt.addOption(pendejo);
		qt.setType(QuestionType.OPCION_MULTIPLE_RESP);

		survey.addQuestion(qt);
		survey.addQuestion(qt2);
		survey.addQuestion(qt3);
		
		suvCtrl.addSurvey(survey);		
		
		return survey;
	} 
	
}
