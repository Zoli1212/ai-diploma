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
		
		JobPostingDao dao = new JobPostingDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		JobPosting post = dao.getJobPostingById(id);
		
		
		if(post == null) {
			request.setAttribute("error", true);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
			rd.forward(request, response);
		}
		
		if(post.getJobPostingPassword().equals(request.getParameter("password"))) {
			dao.removeJobPosting(id);
			System.out.println("Sikeres torles");
			RequestDispatcher rd = request.getRequestDispatcher("/removeJobSuccess.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("error", true);
			RequestDispatcher rd = request.getRequestDispatcher("/removeJob.jsp");
			rd.forward(request, response);
		}
	}

}
