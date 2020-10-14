package com.sirius.jobportal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sirius.jobportal.dao.JobPostingDAO;
import com.sirius.jobportal.entity.JobPosting;

/**
 * Servlet implementation class ViewJobsServlet
 */
@WebServlet("/viewJobs")
public class ViewJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewJobsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		JobPostingDAO dao = new JobPostingDAO();

		System.out.println("adatkapcsolat rendben");

		List<JobPosting> jobs = dao.getAllJobPostings();

		request.setAttribute("jobs", jobs);

		RequestDispatcher rd = request.getRequestDispatcher("/viewJobs.jsp");

		System.out.println("kérés rendben");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
