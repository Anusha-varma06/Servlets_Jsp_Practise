package com.servlets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;

@WebServlet("/Uregistration")
public class Uregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    
    public Uregistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession();
		
		try {
			Connection cons=Dbconnection.connect();
			String name=request.getParameter("username");
			String password=(String)request.getParameter("password");
			String email=(String)request.getParameter("email");
			String mobile=(String)request.getParameter("mobile number");
			String gender=request.getParameter("gender");
			String query1="select * from demo where name=? and password=?";
			PreparedStatement ps1=cons.prepareStatement(query1);
			ps1.setString(1,name);
			ps1.setString(2,password);
			ResultSet rs1=ps1.executeQuery();
			hs.setAttribute("name", name);
			hs.setAttribute("password", password);
			hs.setAttribute("email", email);
			hs.setAttribute("mobile", mobile);
			hs.setAttribute("gender", gender);
			
			if(rs1.next()) {
				response.setContentType("text/html");
				pw.print("already registered please login");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		    	rd.include(request, response);
			}
			else {
				String query="insert into demo values(?,?,?,?,?)";
				PreparedStatement ps=cons.prepareStatement(query);
				ps.setString(1,name);
				ps.setString(2,password);
				ps.setString(3,email);
				ps.setString(4,mobile);
				ps.setString(5,gender);
				int i=ps.executeUpdate();
			    if(i>0) {
			    	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			    	rd.forward(request, response);
			    }
			    else {
			    	pw.print("failed");
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
