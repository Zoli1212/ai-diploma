package com.webler.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webler.entity.JobPosting;

public class JobPostingDao {
	
	private Connection conn;
	
	public JobPostingDao() {
		
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3306/jobportal3?useTimezone=true&serverTimezone=UTC&useSSL=false";
		
		final String USER = "student";
		final String PASS = "student";
		
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(conn==null) {
			System.out.println("Connection failures");
		}else {
			System.out.println("Connection get ready");
		}
		
		
	}
	
	public JobPosting getJobPostingById(int id) {
		
		Statement st;
		
		try {
			st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM jobpostings WHERE id ="+id);
			
			if(rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();
				
				jobPostToReturn.setId(rs.getInt("id"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));
				
				
				
				
				return jobPostToReturn;
			}
			
			st.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void insertJobPosting(JobPosting posting) {
		String sep = "','";
		
		try {
			Statement st = conn.createStatement();
			
			String sqlquery = "INSERT INTO jobpostings(messagebody, jobname, postername, contactphone, jobpostingpassword) VALUES('"
					+ posting.getMessageBody() + sep + posting.getJobName() + sep + posting.getPosterName() + sep
					+ posting.getContactPhone() + sep + posting.getJobPostingPassword() +"')";
			
			System.out.println(sqlquery);
			st.executeUpdate(sqlquery);
			st.close();
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeJobPosting(int JobPostingId) {
		Statement st;
		
		try {
			st = conn.createStatement();
			
			String sql = "DELETE FROM jobpostings WHERE id ="+JobPostingId;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<JobPosting> getAllJobPostings() throws SQLException{
		Statement st;
		ResultSet rs;
		
		st = conn.createStatement();
		rs = st.executeQuery("SELECT * FROM jobpostings limit 200");
		
		
		List<JobPosting> jobs = new ArrayList<>();
		
		while(rs.next()) {
			JobPosting jobPostToAdd = new JobPosting();
			
			jobPostToAdd.setContactPhone(rs.getString("contactPhone"));
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
		
	}

	private void printResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		
		int columnCount = resultSetMetaData.getColumnCount();
		
		while(rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				if(i > 1) System.out.println(", ");
				String columnValue =rs.getString(i);
				System.out.println(columnValue + " "+ resultSetMetaData.getColumnName(i));
				
			}
			
			System.out.println("");
		}
		
		
		
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
