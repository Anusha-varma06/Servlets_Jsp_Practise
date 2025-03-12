package com.servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/EditData")
/**
 * Servlet implementation class Editdata
 */
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try {
			String name=(String)request.getParameter("uname");
			String password=(String)request.getParameter("password");
			String email=(String)request.getParameter("email");
			String mobile=(String)request.getParameter("mobile");
			String gender=(String)request.getParameter("gender");
			pw.print("<form action=Changes>");
			pw.print("username:<input type=text name=uname value="+name+">");
			pw.print("password:<input type=text name=password value="+password+">");
			pw.print("email:<input type=text name=email value="+email+">");
			pw.print("mobile:<input type=text name=mobile value="+mobile+">");
			pw.print("gender:<input type=text name=gender value="+gender+">");
			pw.print("<input type=submit value=submit>");
			pw.print("</form>");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
