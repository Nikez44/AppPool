package com.community.survey.models;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

public class Section {

	public static final String ID = "Id";
	public static final String SECTION_LEADER = "SectionLeader";

	public Section() {
	}

	public User getSectionLeader() {
		return sectionLeader;
	}

	@SerializedName(ID)
	@DatabaseField(columnName = ID, generatedId = true)
	private int id;
	@SerializedName(SECTION_LEADER)
	@DatabaseField(foreign = true, columnName = SECTION_LEADER, foreignColumnName = User.ID)
	private User sectionLeader;
}
