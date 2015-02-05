package com.community.survey.controllers;

import java.util.ArrayList;
import java.util.List;

import com.community.survey.models.Answer;
import com.community.survey.models.QuestionTemplate;
import com.community.survey.repository.interfaces.AnswerRepository;
import com.community.survey.repository.interfaces.SearchCriteria;
import com.google.inject.Inject;

public class AnswerController {
	public AnswerController(AnswerRepository AnswerRepo){
		mAnswerRepo = AnswerRepo;
	}
	
	@Inject
	public AnswerController(){
		
	}
	
	public void addAnswer(Answer answer){
		mAnswerRepo.addObject(answer);
	}
	
	public void addCollectionOfAnswers(List<Answer> answers){
		mAnswerRepo.addObjects(answers);
	}
	
	public void deleteAnswer(Answer answer){
		mAnswerRepo.deleteObject(answer);
	}
	
	public void deleteCollectionOfAnswers(List<Answer> answers){
		mAnswerRepo.deleteObjects(answers);
	}
	
	public void updateAnswer(Answer answer){
		mAnswerRepo.updateObject(answer);
	}
	
	public void updateCollectionOfAnswers(List<Answer> answers){
		mAnswerRepo.updateObjects(answers);
	}
	
	public List<Answer> getAll(){
		return mAnswerRepo.fetchAll();
	}
	
	public List<Answer> getById(String ID){
		SearchCriteria.Builder bldr = new SearchCriteria.Builder();
		bldr.addCriteria(Answer.ID, ID);
		//answer.id campo que busco, id especifico que busco
		SearchCriteria sc = bldr.build();
		
		List<Answer> answers = mAnswerRepo.fetchByCriteria(sc);
		
		return answers;
	}
	
	public List<Answer> retrieveAnswerForQuestions(QuestionTemplate question){
		List<Answer> answers = getAll();
		List<Answer> answersByTemplate = new ArrayList<Answer>();
		for(Answer answer : answers){
			if(answer.getQuestion().getId() == question.getId()){
				answersByTemplate.add(answer);
			}
		}
		
		return answersByTemplate;
	}
	
	@Inject
	private AnswerRepository mAnswerRepo;
}
