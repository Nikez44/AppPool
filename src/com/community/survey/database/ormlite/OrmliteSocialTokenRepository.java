package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.SocialToken;
import com.community.survey.repository.interfaces.SocialTokenRepository;

public class OrmliteSocialTokenRepository extends OrmliteBaseRepository<SocialToken> implements SocialTokenRepository{

	public OrmliteSocialTokenRepository(OrmliteDatabaseHelper helper) {
		super(helper, SocialToken.class);
		// TODO Auto-generated constructor stub
	}

}
