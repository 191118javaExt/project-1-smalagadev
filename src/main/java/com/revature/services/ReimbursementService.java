package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAOImpl;

public class ReimbursementService {
	public static List<Reimbursement> findAll() {
		return new ReimbursementDAOImpl().findAll();		
	}
	
	public static List<Reimbursement> findAllByAuthorId(int author_id) {
		return new ReimbursementDAOImpl().findAllByAuthorId(author_id);		
	}
	
	public static boolean insert(Reimbursement r) {
		return new ReimbursementDAOImpl().insert(r);		
	}
	
	public static boolean update(Reimbursement r) {
		return new ReimbursementDAOImpl().update(r);		
	}
}
