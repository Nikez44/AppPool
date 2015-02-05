package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.Binnacle;
import com.community.survey.repository.interfaces.BinnacleRepository;

public class OrmliteBinnacleRepository extends OrmliteBaseRepository<Binnacle> implements BinnacleRepository {

	public OrmliteBinnacleRepository(OrmliteDatabaseHelper helper) {
		super(helper, Binnacle.class);
		// TODO Auto-generated constructor stub
	}

}
