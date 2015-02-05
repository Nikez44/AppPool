package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.User;
import com.community.survey.repository.interfaces.UserRepository;

public class OrmliteUserRepository extends OrmliteBaseRepository<User> implements UserRepository{

	public OrmliteUserRepository(OrmliteDatabaseHelper helper) {
		super(helper, User.class);
		// TODO Auto-generated constructor stub
	}

}
