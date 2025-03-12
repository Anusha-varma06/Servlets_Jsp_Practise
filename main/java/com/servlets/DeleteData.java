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
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteData() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try {
			Connection cons=Dbconnection.connect();
			String name=(String)request.getParameter("uname");
			String query="delete from demo where name=?";
			PreparedStatement ps=cons.prepareStatement(query);
			ps.setString(1,name);
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
