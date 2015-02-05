package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.Location;
import com.community.survey.repository.interfaces.LocationRepository;

public class OrmliteLocationRepository extends OrmliteBaseRepository<Location> implements LocationRepository{

	public OrmliteLocationRepository(OrmliteDatabaseHelper helper) {
		super(helper, Location.class);
		// TODO Auto-generated constructor stub
	}

}
