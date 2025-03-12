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
@WebServlet("/Changes")
/**
 * Servlet implementation class Changes
 */
public class Changes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changes() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try {
			Connection cons=Dbconnection.connect();
			String name=(String)request.getParameter("uname");
			String password=(String)request.getParameter("password");
			String email=(String)request.getParameter("email");
			String mobile=(String)request.getParameter("mobile");
			String gender=(String)request.getParameter("gender");
			String query="update demo set password=?,email=?,mobile=?,gender=? where name=?";
			PreparedStatement ps=cons.prepareStatement(query);
			ps.setString(1,password);
			ps.setString(2,email);
			ps.setString(3,mobile);
			ps.setString(4,gender);
			ps.setString(5,name);
			int res=ps.executeUpdate();
			if(res>0) {
				RequestDispatcher rd=request.getRequestDispatcher("UdisplayData");
				rd.forward(request, response);
			}
			else {
				pw.write("something went wrong");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
