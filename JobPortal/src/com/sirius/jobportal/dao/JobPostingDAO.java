package com.sirius.jobportal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sirius.jobportal.entity.JobPosting;

public class JobPostingDAO {

	private Connection conn;

	public JobPostingDAO() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String Database_URL = "jdbc:mysql://localhost:3310/jobportal?useTimezone=true&serverTimezone=UTC&useSSL=false";

		final String Database_USER = "student";
		final String Database_PASS = "student";

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			this.conn = DriverManager.getConnection(Database_URL, Database_USER, Database_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public JobPosting getJobPostingById(int id) {
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from jobpostings where id = " + id);

			if (rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();

				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setId(rs.getInt("id"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));

				return jobPostToReturn;
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return null;

	}

	public void insertJobPosting(JobPosting posting) {
		String sep = "','";
		try {
			Statement st = conn.createStatement();
			String sqlQuery = "insert into jobpostings(messagebody,jobname,postername,contactphone,jobpostingpassword) values('"
					+ posting.getMessageBody() + sep + posting.getJobName() + sep + posting.getPosterName() + sep
					+ posting.getContactPhone() + sep + posting.getJobPostingPassword() + "')";
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeJobPosting(int jobPostId) {
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("DELETE FROM jobpostings WHERE id = " + jobPostId);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<JobPosting> getAllJobPostings() {
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from jobpostings limit 200");
						
			List<JobPosting> jobs = new ArrayList<JobPosting>();
			while (rs.next()) {

				JobPosting jobPostToAdd = new JobPosting();

				jobPostToAdd.setContactPhone(rs.getString("contactphone"));
				jobPostToAdd.setJobName(rs.getString("jobname"));
				jobPostToAdd.setPosterName(rs.getString("postername"));
				jobPostToAdd.setMessageBody(rs.getString("messagebody"));
				jobPostToAdd.setId(rs.getInt("id"));

				jobs.add(jobPostToAdd);

			}
			
			printResultSet(rs);
			
			st.close();
			rs.close();
			return jobs;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	private void printResultSet(ResultSet rs) throws SQLException {
		
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
	      
	      int columnCount = resultSetMetaData.getColumnCount();
		   while (rs.next()) {
		       for (int i = 1; i <= columnCount; i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs.getString(i);
		           System.out.print(columnValue + " " + resultSetMetaData.getColumnName(i));
		       }
		       System.out.println("");
		   }
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
