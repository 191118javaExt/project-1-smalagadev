package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.NewReimbursementTemplate;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(NewReimbursementServlet.class);
	private static ObjectMapper om = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
//		System.out.println("Someone's at /reimbursement");
//		res.setContentType("application/json");
//		List<Reimbursement> all = ReimbursementService.findAll();
//		List<ReimbursementDTO> allDTO = new ArrayList<>();
//		
//		for(Reimbursement r: all) {
//			allDTO.add( new ReimbursementDTO(r.getId(), r.getAmount(), r.getSubmitted(),
//					r.getResolved(), r.getDescription(), r.getStatus_id(), r.getType_id()));
//		}
//		
//		String json = om.writeValueAsString(all);
//		
//		PrintWriter out = res.getWriter();
//		out.println(json);
//		
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
		System.out.println(body);
		try{
			NewReimbursementTemplate nrt = om.readValue(body, NewReimbursementTemplate.class);
			Reimbursement newR = new Reimbursement(nrt.getAmount(), nrt.getDescription(), nrt.getReceipt(),
					nrt.getAuthor(), nrt.getType_id());
			res.setContentType("application/json");
			if(ReimbursementService.insert(newR)) {
				System.out.println("inserted!");
			}else {
				System.out.println("Failed to insert!");
			}
			
		}catch(Exception e) {
			logger.warn(e);
			System.out.println("Error uploading file.");
		}

		
//		String json = om.writeValueAsString();
//		
//		PrintWriter out = res.getWriter();
//		out.println(json);
	}
}
