<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% int noOfPages = (int) session.getAttribute("totPages");
	 ResultSet rs = (ResultSet) session.getAttribute("txndata");
	 int currentPage = (int) session.getAttribute("page");
	 %>
	 <h4>page no:<%=currentPage%></h4>
	 <table border=2>
	     <tr>
	     	<th>Transaction_Id</th>
	     	<th>Transaction_Date</th>
	     	<th>Transaction_Amt</th>
	     	<th>Source_Account_Id</th>
	     	<th>Destination_Account_Id</th>
	     </tr>
     	<%while(rs.next()) {%>
     		<tr>
     			<td><%=rs.getInt(1) %></td>
     			<td><%=rs.getString(2) %></td>
     			<td><%=rs.getInt(3) %></td>
     			<td><%=rs.getInt(4) %></td>
     			<td><%=rs.getInt(5) %></td>
     		</tr> <%} %>
	 </table>
	 <div>
	   <%
   // if (currentPage > 1) {
%>
   <%-- <a href='Transactions?page=<%=currentPage-1 %>'> &lt;&lt; Previous</a> --%>
<%
   // } else {
%>
   <%-- <span><< Previous</span> --%>
<%
   // }
%>
<%
   // if (currentPage < noOfPages) {
%>
   <%-- <a href='Transactions?page=<%= currentPage+1 %>'>Next >></a> --%>
<%
   // } else {
%>
   <%-- <span>Next >></span> --%>
<%
   // }
%>
	   
	    <%//either way (above or below method) can be followed%>
	  <%
	  if (currentPage > 1) {
				out.print("<a href='Transactions?page=" + (currentPage - 1) + "'><< Previous</a> ");
			} else {
				out.print("<span><< Previous</span> ");
			}

			// Next page link
			if (currentPage < noOfPages) {
				out.print("<a href='Transactions?page=" + (currentPage + 1) + "'>Next >></a>");
			} else {
				out.print("<span>Next >></span>");
			}
	%>		
	 </div>
	  <a href="Profile.jsp?cpage=<%=currentPage%>">go to profile page</a>
</body>
</html>