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

/**
 * Servlet implementation class RemoveJobServlet
 */
@WebServlet("/RemoveJob")
public class RemoveJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JobPostingDAO dao = new JobPostingDAO();
		
		int jobPostinId = Integer.parseInt(request.getParameter("id"));
		
		JobPosting post = dao.getJobPostingById(jobPostinId);
		
		if (post==null) {
			
			request.setAttribute("error", true);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
			rd.forward(request, response);
		}
		System.out.println("OK");
		if (post.getJobPostingPassword().equals(request.getParameter("password"))) {
			
			dao.removeJobPosting(jobPostinId);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJobSuccess.jsp");
			rd.forward(request, response);
		}
		else {
			
			request.setAttribute("error", true);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
			rd.forward(request, response);
		}
	}

}
