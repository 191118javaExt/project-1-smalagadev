package com.revature.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	private static Logger logger = Logger.getLogger(ReimbursementDAOImpl.class);

	@Override
	public List<Reimbursement> findAll() {
		
		List<Reimbursement> list = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM  Reimbursements;";
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("reimbursement_id");
				double amount = rs.getDouble("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("description");
				int author = rs.getInt("author");
				int status = rs.getInt("status_id");
				int type = rs.getInt("type_id");
				
				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, author, status, type);
				list.add(r);
			}
			rs.close();
		}
		catch(SQLException e) {
			logger.warn(e);
			return null;
		}
		return list;
	}

	@Override
	public List<Reimbursement> findAllByAuthorId(int author_id) {
		List<Reimbursement> list = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM  Reimbursements WHERE author = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, author_id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("reimbursement_id");
				double amount = rs.getDouble("amount");
				Date submitted = rs.getDate("submitted");
				Date resolved = rs.getDate("resolved");
				String description = rs.getString("description");
				int status = rs.getInt("status_id");
				int type = rs.getInt("type_id");
				
				Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, status, type);
				list.add(r);
			}
			rs.close();
		}
		catch(SQLException e) {
			logger.warn(e);
			return null;
		}
		return list;
	}

	@Override
	public boolean insert(Reimbursement r) {
		try(Connection conn = ConnectionUtil.getConnection()){

			
			String sql = "INSERT INTO reimbursements (amount, description, receipt, author, type_id) "
					+ "VALUES (?, ?, ?, ?, ?);";

//			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setDouble(1, r.getAmount());
			stmt.setString(2, r.getDescription());
//			stmt.setBinaryStream(3, r.getReceipt());
			stmt.setBlob(3, r.getReceipt());
			stmt.setInt(4, r.getAuthor());
			stmt.setInt(5, r.getType_id());
			
			
			if(!stmt.execute()) {
				return false;
			}	
//			conn.commit();
//			conn.setAutoCommit(true);
		}
		catch(Exception e) {
			logger.warn(e);
			try(Connection conn= ConnectionUtil.getConnection()){
				String sql = "INSERT INTO reimbursements (amount, description, author, type_id) "
						+ "VALUES (?, ?, ?, ?);";

				PreparedStatement stmt = conn.prepareStatement(sql);

				stmt.setDouble(1, r.getAmount());
				stmt.setString(2, r.getDescription());
				stmt.setInt(3, r.getAuthor());
				stmt.setInt(4, r.getType_id());
				
				
				if(!stmt.execute()) {
					return false;
				}
				System.out.println("File not uploaded.");
			}catch(SQLException ex) {
				logger.warn(ex);
			}
			
			return true;
		}
		return true;
	}


	@Override
	public boolean update(Reimbursement r) {
try(Connection conn = ConnectionUtil.getConnection()){

			
			String sql = "UPDATE reimbursements "
					+ "SET (resolved = current_date)"
					+ "(resolver = ?)"
					+ "(status_id= ?)"
					+ "WHERE (reimbursement_id = ?);";


			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, r.getResolver());
			stmt.setInt(2, r.getStatus_id());
			stmt.setInt(3, r.getId());
			
			if(!stmt.execute()) {
				return false;
			}	
		}
		catch(Exception e) {
			logger.warn(e);
			return false;
		}
		return true;
	}

	@Override
	public Reimbursement findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
