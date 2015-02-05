package com.community.survey.repository.interfaces;

import java.util.HashMap;
import java.util.Map;

public class SearchCriteria {
	
	public static class Builder {
		
		public Builder(){
			criteriaMap = new HashMap<String, Object>();
		}
		
		public Builder addCriteria(String key, Object value){
			criteriaMap.put(key, value);
			return this;
		}
		
		public SearchCriteria build(){
			return new SearchCriteria(criteriaMap);
		}
		
		private Map<String, Object> criteriaMap;
	}
	
	public Map<String, Object> getCriteria(){
		return criteriaMap;
	}
	
	private SearchCriteria(Map<String, Object> criteriaMap){
		this.criteriaMap = criteriaMap;
	}
	
	private Map<String, Object> criteriaMap;
}
