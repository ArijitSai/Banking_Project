<%@page import="Dto.Customer"%>
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
<h1>Welcome to balance Page</h1>

<%long acno =(long)request.getSession().getAttribute("ac_number");
BankDao bankDao=new BankDao();
Bank_account bank_account=bankDao.find(acno);

Customer customer=bank_account.getCustomer();
%>
<h1>Hello<%if(customer.getGender().equals("male")){%> Mr<%} else {%> Ms.<%} %> <%=customer.getCname() %> Your Account Balance is: <%=bank_account.getAmount() %></h1>

<a href="Accounthome.html"><button>Back</button></a>
</body>

</html>