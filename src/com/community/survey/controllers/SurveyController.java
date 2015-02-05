package com.community.survey.controllers;

import java.util.List;

import com.community.survey.models.SurveyTemplate;
import com.community.survey.repository.interfaces.SearchCriteria;
import com.community.survey.repository.interfaces.SurveyTemplateRepository;
import com.google.inject.Inject;

public class SurveyController {
	
	public SurveyController(SurveyTemplateRepository surveyTemplateRepo){
		mSurveyRepo = surveyTemplateRepo;
	}
	
	@Inject
	public SurveyController(){
		
	}
	
	public void addSurvey(SurveyTemplate template){
		mSurveyRepo.addObject(template);
	}
	
	public void addCollectionOfSurveys(List<SurveyTemplate> surveys){
		mSurveyRepo.addObjects(surveys);
	}
	
	public void deleteSurvey(SurveyTemplate template){
		mSurveyRepo.deleteObject(template);
	}
	
	public void deleteCollectionOfSurveys(List<SurveyTemplate> surveys){
		mSurveyRepo.deleteObjects(surveys);
	}
	
	public void updateSurvey(SurveyTemplate template){
		mSurveyRepo.updateObject(template);
	}
	
	public void updateCollectionOfSurveys(List<SurveyTemplate> surveys){
		mSurveyRepo.updateObjects(surveys);
	}
	
	public List<SurveyTemplate> getAll(){
		return mSurveyRepo.fetchAll();
	}
	
	public List<SurveyTemplate> getById(String ID){
		SearchCriteria.Builder bldr = new SearchCriteria.Builder();
		bldr.addCriteria(SurveyTemplate.ID, ID);
		SearchCriteria sc = bldr.build();
		
		List<SurveyTemplate> surveys = mSurveyRepo.fetchByCriteria(sc);
		
		return surveys;
	}
	
	@Inject
	private SurveyTemplateRepository mSurveyRepo;
}
