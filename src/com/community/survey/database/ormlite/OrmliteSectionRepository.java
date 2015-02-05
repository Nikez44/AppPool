package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.Section;
import com.community.survey.repository.interfaces.SectionRepository;

public class OrmliteSectionRepository extends OrmliteBaseRepository<Section> implements SectionRepository{

	public OrmliteSectionRepository(OrmliteDatabaseHelper helper) {
		super(helper, Section.class);
		// TODO Auto-generated constructor stub
	}

}
