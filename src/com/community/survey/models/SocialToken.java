package com.community.survey.models;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class SocialToken {

	public static final String SOCIAL_NETWORK_NAME = "SocialNetworkName";
	public static final String SOCIAL_TOKEN = "SocialToken";
	public static final String USER = "User";

	public String getSocialNetworkName() {
		return socialNetworkName;
	}

	public void setSocialNetworkName(String socialNetworkName) {
		this.socialNetworkName = socialNetworkName;
	}

	public String getSocialToken() {
		return socialToken;
	}

	public void setSocialToken(String socialToken) {
		this.socialToken = socialToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@SerializedName(SOCIAL_NETWORK_NAME)
	@DatabaseField(columnName = SOCIAL_NETWORK_NAME)
	private String socialNetworkName;
	@SerializedName(SOCIAL_TOKEN)
	@DatabaseField(columnName = SOCIAL_TOKEN)
	private String socialToken;
	@SerializedName(USER)
	@DatabaseField(foreign = true, foreignColumnName = User.ID, columnName = USER)
	private User user;

}
