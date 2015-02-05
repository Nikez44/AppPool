package com.community.survey.admin.models;

import com.community.survey.models.Section;
import com.community.survey.models.User;
import com.community.survey.models.UserType;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class AdminTask extends User {

	public AdminTask() {
	}

	public AdminTask(String name, String password, Section section) {
		this.setType(UserType.ADMIN_TAREA);
		this.setPassword(password);
		this.setSection(section);
	}

}
