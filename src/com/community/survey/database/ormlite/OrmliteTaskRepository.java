package com.community.survey.database.ormlite;

import com.community.survey.database.OrmliteDatabaseHelper;
import com.community.survey.models.Task;
import com.community.survey.repository.interfaces.TaskRepository;

public class OrmliteTaskRepository extends OrmliteBaseRepository<Task> implements TaskRepository{

	public OrmliteTaskRepository(OrmliteDatabaseHelper helper) {
		super(helper, Task.class);
		// TODO Auto-generated constructor stub
	}

}
