package com.community.survey.controllers;

import java.util.List;

import com.community.survey.models.QuestionTemplate;
import com.community.survey.repository.interfaces.QuestionTemplateRepository;
import com.community.survey.repository.interfaces.SearchCriteria;
import com.google.inject.Inject;

public class QuestionsController {
	public QuestionsController(QuestionTemplateRepository questionTemplateRepo){
		mQuestionRepo = questionTemplateRepo;
	}
	
	@Inject
	public QuestionsController(){
		
	}
	
	public void addQuestion(QuestionTemplate template){
		mQuestionRepo.addObject(template);
	}
	
	public void addCollectionOfQuestions(List<QuestionTemplate> questions){
		mQuestionRepo.addObjects(questions);
	}
	
	public void deleteQuestion(QuestionTemplate template){
		mQuestionRepo.deleteObject(template);
	}
	
	public void deleteCollectionOfQuestions(List<QuestionTemplate> questions){
		mQuestionRepo.deleteObjects(questions);
	}
	
	public void updateQuestion(QuestionTemplate template){
		mQuestionRepo.updateObject(template);
	}
	
	public void updateCollectionOfQuestions(List<QuestionTemplate> questions){
		mQuestionRepo.updateObjects(questions);
	}
	
	public List<QuestionTemplate> getAll(){
		return mQuestionRepo.fetchAll();
	}
	
	public List<QuestionTemplate> getById(String ID){
		SearchCriteria.Builder bldr = new SearchCriteria.Builder();
		bldr.addCriteria(QuestionTemplate.ID, ID);
		SearchCriteria sc = bldr.build();
		
		List<QuestionTemplate> questions = mQuestionRepo.fetchByCriteria(sc);
		
		return questions;
	}
	
	@Inject
	private QuestionTemplateRepository mQuestionRepo;
}
