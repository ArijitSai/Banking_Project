<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to admin home page</h1>
<%List<Bank_account> list= (List<Bank_account>)request.getSession().getAttribute("list"); %>
<table border="1">
<tr>
<th>Account_number</th>
<th>Account_type</th>
<th>Customer_name</th>
<th>Customer_id</th>
<th>Account_Status</th>
<th>Change_Status</th>
</tr>

<%for(Bank_account bank_account:list) { %>

<tr>
<th><%=bank_account.getAcc_no() %></th>
<th><%=bank_account.getAccount_type() %></th>
<th><%=bank_account.getCustomer().getCname() %></th>
<th><%=bank_account.getCustomer().getCid() %></th>
<th><%=bank_account.isStatus() %></th>

<th><a href="changestatus?acno=<%=bank_account.getAcc_no() %>"><button>Change Status</button></a></th>
</tr>
<%} %>

</table>
</body>
</html>