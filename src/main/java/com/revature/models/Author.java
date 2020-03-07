package com.revature.models;

public class Author {
	private int user_id;

	public Author() {
		super();
	}
	
	public Author(int author_id) {
		super();
		this.user_id = author_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int author_id) {
		this.user_id = author_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + user_id + "]";
	}
}
