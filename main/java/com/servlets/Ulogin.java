package com.servlets;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/Ulogin")
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ulogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter pw=response.getWriter();
		try {
			Connection cons=Dbconnection.connect();
			String name=(String)request.getParameter("username");
			String password=(String)request.getParameter("password");
			String query="select * from demo where name=? and password=?";
			PreparedStatement ps=cons.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
		    if(rs.next()) {
		    	//request.setAttribute("name",name);
				//srequest.setAttribute("password","xxxxxxxxxx");
		    	RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");
		    	rd.forward(request, response);
		    }
		    else {
		    	response.setContentType("text/html");
		    	pw.print("invalid credentials");
		    	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		    	rd.include(request, response);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
