package com.revature.repositories;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	public List<Reimbursement> findAll();
	public Reimbursement findById(int id);
	public boolean insert(Reimbursement r);
	public boolean update(Reimbursement r);
	public boolean delete(Reimbursement r);
}
