package com.community.survey.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class User {

	public static final String ID = "Id";
	public static final String TYPE = "Type";
	public static final String NAME = "Name";
	public static final String PASSWORD = "Password";
	public static final String SECTION = "Section";
	public static final String SOCIAL_TOKENS = "SocialTokens";

	public User() {
	}

	public User(UserType tipo, String nombre, String password, Section seccion) {
		this.type = tipo;
		this.name = nombre;
		this.password = password;
		this.section = seccion;
		this.socialTokens = new ArrayList<SocialToken>();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public void setPassword(String password) {
		if (password == null || password.length() < 0) {
			throw new IllegalArgumentException(
					"Password can't be Null or Empty");
		}
		this.password = password;
	}

	public SocialToken getTokenForNetwork(String socialNetwork) {
		SocialToken token = null;
		for (SocialToken currentToken : socialTokens) {
			if (currentToken.getSocialNetworkName().equalsIgnoreCase(
					socialNetwork)) {
				token = currentToken;
				break;
			}
		}
		return token;
	}

	public List<SocialToken> getSocialTokens() {
		ArrayList<SocialToken> items = new ArrayList<SocialToken>();
		if (socialTokens != null) {
			for (SocialToken item : socialTokens) {
				items.add(item);
			}
		}
		return items;
	}

	public void setSocialTokens(List<SocialToken> list) {
		this.socialTokens = list;
		if (this.socialTokens != null) {
			for (SocialToken token : this.socialTokens) {
				setUserToSocialToken(token);
			}
		}
	}

	public void addToken(SocialToken token) {
		mayInitTokenList();
		setUserToSocialToken(token);
		socialTokens.add(token);
	}

	private void mayInitTokenList() {
		if (socialTokens == null) {
			socialTokens = new ArrayList<SocialToken>();
		}
	}

	private void setUserToSocialToken(SocialToken token) {
		if (token != null) {
			token.setUser(this);
		}
	}

	@DatabaseField(columnName = ID, generatedId = true)
	@SerializedName(ID)
	private int id;
	@DatabaseField(columnName = TYPE, dataType = DataType.ENUM_INTEGER)
	@SerializedName(TYPE)
	private UserType type;
	@DatabaseField(columnName = NAME)
	@SerializedName(NAME)
	private String name;
	@SerializedName(PASSWORD)
	@DatabaseField(columnName = PASSWORD)
	private String password;
	@SerializedName(SOCIAL_TOKENS)
	@ForeignCollectionField(eager = true)
	private Collection<SocialToken> socialTokens;
	@SerializedName(SECTION)
	@DatabaseField(columnName = SECTION, foreign = true, foreignColumnName = Section.ID)
	private Section section;

}
