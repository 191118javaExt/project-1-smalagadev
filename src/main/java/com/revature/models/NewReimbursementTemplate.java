package com.revature.models;

import java.io.ObjectInputStream;

public class NewReimbursementTemplate {
	private static final long serialVersionUID = 1L;
	
	private double amount;
	private String description;
	private ObjectInputStream receipt;
	private int type_id;
	private int author;
	
	public NewReimbursementTemplate() {
		super();
	}

	public NewReimbursementTemplate(double amount, String description, ObjectInputStream receipt, int type_id,
			int author) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.type_id = type_id;
		this.author = author;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ObjectInputStream getReceipt() {
		return receipt;
	}

	public void setReceipt(ObjectInputStream receipt) {
		this.receipt = receipt;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + type_id;
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
		NewReimbursementTemplate other = (NewReimbursementTemplate) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author != other.author)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (type_id != other.type_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewReimbursementTemplate [amount=" + amount + ", description=" + description + ", receipt=" + receipt
				+ ", type_id=" + type_id + ", author=" + author + "]";
	}

	
}
