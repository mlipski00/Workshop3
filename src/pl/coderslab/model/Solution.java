package pl.coderslab.model;

import java.sql.Timestamp;

public class Solution {

	private int id;
	private Timestamp created;
	private Timestamp updated;
	private String description;
	private int excercise_id;
	private int user_id;

	public Solution(String description, int excercise_id, int user_id) {
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime();
		this.created = new Timestamp(javaTime);
		this.updated = new Timestamp(javaTime);
		this.description = description;
		this.excercise_id = excercise_id;
		this.user_id = user_id;
	}

	public Solution() {
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExcercise_id(int excercise_id) {
		this.excercise_id = excercise_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", created=" + created + ", updated=" + updated + ", description=" + description
				+ ", excercise_id=" + excercise_id + ", user_id=" + user_id + "]\n";
	}

	public int getExcercise_id() {
		return excercise_id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
