package pl.coderslab.model;

public class Group {

	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Group(String name) {
		this.name = name;
	}

	public Group() {

	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
