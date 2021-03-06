package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Author;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.services.ReimbursementService;

public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ReimbursementServlet.class);
	private static ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("Someone's at /reimbursement");
		res.setContentType("application/json");
		List<Reimbursement> all = ReimbursementService.findAll();
		List<ReimbursementDTO> allDTO = new ArrayList<>();
		
		for(Reimbursement r: all) {
			allDTO.add( new ReimbursementDTO(r.getId(), r.getAmount(), r.getSubmitted(),
					r.getResolved(), r.getDescription(), r.getStatus_id(), r.getType_id()));
		}
		
		String json = om.writeValueAsString(all);
		
		PrintWriter out = res.getWriter();
		out.println(json);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println(s);
		Author a = om.readValue(body, Author.class);
		int author_id = a.getUser_id();
		
		res.setContentType("application/json");
		List<Reimbursement> all = ReimbursementService.findAllByAuthorId(author_id);
		List<ReimbursementDTO> allDTO = new ArrayList<>();
		
		for(Reimbursement r: all) {
			allDTO.add( new ReimbursementDTO(r.getId(), r.getAmount(), r.getSubmitted(),
					r.getResolved(), r.getDescription(), r.getStatus_id(), r.getType_id()));
		}
		
		String json = om.writeValueAsString(all);
		
		PrintWriter out = res.getWriter();
		out.println(json);
	}
}
