package com.sirius.jobportal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sirius.jobportal.dao.JobPostingDAO;
import com.sirius.jobportal.entity.JobPosting;

@WebServlet("/")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostJobServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/postJob.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String messageBody = request.getParameter("messagebody");
		String contactPhone = request.getParameter("contactphone");
		String posterName = request.getParameter("postername");
		String jobName = request.getParameter("jobname");
		String jobPostingPassword = request.getParameter("password");
		
		JobPosting jobPost = new JobPosting();
		
		jobPost.setMessageBody(messageBody);
		jobPost.setContactPhone(contactPhone);
		jobPost.setPosterName(posterName);
		jobPost.setJobName(jobName);
		jobPost.setJobPostingPassword(jobPostingPassword);
		 
		System.out.println(jobPost);
		
		JobPostingDAO dao = new JobPostingDAO();
		
		
		dao.insertJobPosting(jobPost);
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/postJobSuccess.jsp");
		rd.forward(request, response);
		 

	}

}
