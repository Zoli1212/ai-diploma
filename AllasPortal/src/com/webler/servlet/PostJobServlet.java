package com.webler.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webler.dao.JobPostingDao;
import com.webler.entity.JobPosting;

/**
 * Servlet implementation class PostJobServlet
 */
@WebServlet("/")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/postJob.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String messageBody = request.getParameter("messageBody");
		String contactPhone = request.getParameter("contactphone");
		String posterName = request.getParameter("posterName");
		String jobName = request.getParameter("jobName");
		String jobPostingPassword = request.getParameter("password");
		
		JobPosting jobPost = new JobPosting();
		
		jobPost.setJobName(jobName);
		jobPost.setContactPhone(contactPhone);
		jobPost.setMessageBody(messageBody);
		jobPost.setPosterName(posterName);
		jobPost.setJobPostingPassword(jobPostingPassword);
		
		System.out.println(jobPost);
		
		JobPostingDao dao = new JobPostingDao();
		
		dao.insertJobPosting(jobPost);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/postJobSucces.jsp");
		
		rd.forward(request, response);
		
		// +1 Zsolti
	}

}
