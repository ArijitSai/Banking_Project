<%@page import="Dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Transaction Page</h1>


<% long acno=(long)request.getSession().getAttribute("ac_number");
BankDao bankDao=new BankDao();
Bank_account bank_Account=bankDao.find(acno);
List<BankTransaction> list=bank_Account.getList();

%>
<%= bank_Account.getAcc_no() %>
<%=bank_Account.getAccount_type() %>


<table border="1">
<tr>
<td>Tid</td>
<td>Deposit</td>
<td>Withdraw</td>
<td>view_Transaction</td>
<td>Date</td>
</tr>
<% for(BankTransaction bankTransaction: list) { %>
<tr>
<td><%= bankTransaction.getTid() %> </td>
<td><%= bankTransaction.getDeposit() %> </td>
<td><%= bankTransaction.getWithdraw() %> </td>
<td><%= bankTransaction.getBalance() %> </td>
<td><%= bankTransaction.getDate_time()%></td>
<%} %>
</tr>
</table>
<a href="Accounthome.html"><button>Back</button></a>
</body>
</html>