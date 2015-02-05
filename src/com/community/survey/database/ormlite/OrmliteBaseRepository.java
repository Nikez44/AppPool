package com.community.survey.database.ormlite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import android.util.Log;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.repository.interfaces.Repository;
import com.community.survey.repository.interfaces.SearchCriteria;
import com.j256.ormlite.dao.Dao;

public class OrmliteBaseRepository<T> implements Repository<T>{

	public OrmliteBaseRepository(OrmliteDatabaseHelper helper, Class<T> clazz){
		mHelper = helper;
		mClazz = clazz;
		initDao();
	}
	
	@Override
	public List<T> fetchAll() {
		// TODO Auto-generated method stub
		List<T> data;
		try {
			data = mDao.queryForAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			data = new ArrayList<T>();
		}
		return data;
	}

	@Override
	public List<T> fetchByCriteria(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		List<T> data;
		try{
			data = mDao.queryForFieldValues(criteria.getCriteria());
		}catch(SQLException e){
			data = new ArrayList<T>();
		}
		return data;
	}

	@Override
	public int addObject(T object) {
		// TODO Auto-generated method stub
		int addedObject = 0;
		try{
			addedObject = mDao.create(object);
		}catch(SQLException e){
			e.printStackTrace();
		}

		Log.i(TAG, "Created: " + addedObject + " -> " + mClazz.getSimpleName() + " Object");
		
		return addedObject;
	}

	@Override
	public int addObjects(final List<T> objectList) {
		// TODO Auto-generated method stub
		int addedObjects = 0;
		
		try {
			addedObjects = mDao.callBatchTasks(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					int objectsAdded = 0;
					for(T currentObject : objectList){
						objectsAdded += addObject(currentObject);
					}
					return objectsAdded;
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addedObjects;
	}

	@Override
	public int deleteObject(T object) {
		// TODO Auto-generated method stub
		int deletedObject = 0;
		
		try {
			deletedObject =mDao.delete(object);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.i(TAG, "Deleted: " + deletedObject + " -> " + mClazz.getSimpleName() + " object");
		
		return deletedObject;
	}

	@Override
	public int deleteObjects(final List<T> objectList) {
		// TODO Auto-generated method stub
		int deletedObjects = 0;
		
		try {
			deletedObjects = mDao.callBatchTasks(new Callable<Integer>(){

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					int deletedObjects = 0;
					
					for(T currentObject : objectList){
						deletedObjects += deleteObject(currentObject);
					}
					
					return deletedObjects;
				}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return deletedObjects;
	}

	@Override
	public int updateObject(T object) {
		// TODO Auto-generated method stub
		int updatedObject = 0;
		
		try {
			updatedObject = mDao.update(object);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.i(TAG, "Updated: " + updatedObject + " -> " + mClazz.getSimpleName() + " Object");
		
		return updatedObject;
	}

	@Override
	public int updateObjects(final List<T> objectList) {
		// TODO Auto-generated method stub
		int updatedObjects = 0;
		
		try {
			updatedObjects = mDao.callBatchTasks(new Callable<Integer>(){

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					int updatedObjects = 0;
					
					for(T currentObject : objectList){
						updatedObjects += updateObject(currentObject);
					}
					
					return updatedObjects;
				}
				
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updatedObjects;
	}

	private void initDao(){
		try {
			mDao = mHelper.getDao(mClazz);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String TAG = OrmliteBaseRepository.class.getSimpleName();
	
	private Dao<T, Integer> mDao;
	private OrmliteDatabaseHelper mHelper;
	private Class<T> mClazz;
}
