package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Excercise {

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	private String title;
	private String description;

	public Excercise(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Excercise() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}


}
