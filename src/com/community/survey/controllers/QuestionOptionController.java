package com.community.survey.controllers;

import java.util.List;

import com.community.survey.models.QuestionOption;
import com.community.survey.repository.interfaces.QuestionOptionRepository;
import com.community.survey.repository.interfaces.SearchCriteria;
import com.google.inject.Inject;

public class QuestionOptionController {
	public QuestionOptionController(QuestionOptionRepository questionOptionRepo){
		mQuestionOptRepo = questionOptionRepo;
	}
	
	@Inject
	public QuestionOptionController(){
		
	}
	
	public void addQuestionOption(QuestionOption option){
		mQuestionOptRepo.addObject(option);
	}
	
	public void addCollectionOfQuestionsOptions(List<QuestionOption> options){
		mQuestionOptRepo.addObjects(options);
	}
	
	public void deleteQuestionOption(QuestionOption option){
		mQuestionOptRepo.deleteObject(option);
	}
	
	public void deleteCollectionOfQuestionOptions(List<QuestionOption> options){
		mQuestionOptRepo.deleteObjects(options);
	}
	
	public void updateQuestionOption(QuestionOption option){
		mQuestionOptRepo.updateObject(option);
	}
	
	public void updateCollectionOfQuestionOptionss(List<QuestionOption> options){
		mQuestionOptRepo.updateObjects(options);
	}
	
	public List<QuestionOption> getAll(){
		return mQuestionOptRepo.fetchAll();
	}
	
	public List<QuestionOption> getById(String ID){
		SearchCriteria.Builder bldr = new SearchCriteria.Builder();
		bldr.addCriteria(QuestionOption.ID, ID);
		SearchCriteria sc = bldr.build();
		
		List<QuestionOption> questions = mQuestionOptRepo.fetchByCriteria(sc);
		
		return questions;
	}
	
	@Inject
	private QuestionOptionRepository mQuestionOptRepo;
}
