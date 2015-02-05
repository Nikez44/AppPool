package com.community.survey.repository.interfaces;

import java.util.List;

public interface WritableRepository<T> {
	public int addObject(T object);
	public int addObjects(List<T> objectList);
	
	public int deleteObject(T object);
	public int deleteObjects(List<T> objectList);
	
	public int updateObject(T object);
	public int updateObjects(List<T> objectList);
}
