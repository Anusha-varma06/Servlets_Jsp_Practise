package com.servlets;
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
@WebServlet("/UdisplayData")
public class UdisplayData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UdisplayData() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try {
			Connection cons=Dbconnection.connect();
			String query="select * from demo";
			PreparedStatement ps=cons.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			pw.print("<table border=2>");
			pw.print("<tr>");
			pw.print("<th>User name</th>");
			pw.print("<th>email</th>");
			pw.print("<th>mobile</th>");
			pw.print("<th>gender</th>");
			pw.print("<th>delete</th>");
			pw.print("<th>edit</th>");
			pw.print("</tr>");
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td>"+rs.getString(4)+"</td>");
				pw.print("<td>"+rs.getString(5)+"</td>");
				pw.print("<td>"+"<a href='DeleteData?uname="+rs.getString(1)+"'>delete</a>"+"</td>");
				pw.print("<td>"+"<a href='EditData?uname="+rs.getString(1)+"&password="+rs.getString(2)+"&email="+rs.getString(3)+"&mobile="+rs.getString(4)+"&gender="+rs.getString(5)+"'>edit</a>"+"</td>");
				pw.print("</tr>");
			}
			pw.print("</table>");
			pw.print("<a href='index.html'>home</a>");
	}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
