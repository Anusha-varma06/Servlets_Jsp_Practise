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

@WebServlet("/Transactions")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Transactions() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		try {
			Connection cons=Dbconnection.connect();
			int transactionsPerPage=5;
			int noPages=0;
			int noOfTxns=0;
			int page=1;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			int offset=(page-1)*transactionsPerPage;
			String query1="select count(*) from transactions";
			PreparedStatement ps=cons.prepareStatement(query1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)!=0) {
					noOfTxns=rs.getInt(1);
					noPages=(int)Math.ceil(noOfTxns/transactionsPerPage);
					hs.setAttribute("totPages",noPages);
					hs.setAttribute("page", page);
				}
			}
			
			String query="select * from transactions limit ?  offset ?";
			PreparedStatement ps1=cons.prepareStatement(query);
			ps1.setInt(1, transactionsPerPage);
			ps1.setInt(2, offset);
			ResultSet rs1=ps1.executeQuery();
			hs.setAttribute("txndata", rs1);
			RequestDispatcher rd=request.getRequestDispatcher("TransactionDisplay.jsp");
	    	rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
