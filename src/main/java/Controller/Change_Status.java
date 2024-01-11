package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BankDao;
import Dto.Bank_account;

@WebServlet("/changestatus")
public class Change_Status extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

String ac_no=req.getParameter("acno");
long acc_no=Long.parseLong(ac_no);
BankDao bankDao=new BankDao();

Bank_account bank_account=bankDao.fetch_account_details(acc_no);
if(bank_account.isStatus())
{
bank_account.setStatus(false);	
}
else {
	bank_account.setStatus(true);
	
	
}

bankDao.update_the_details(bank_account);
resp.getWriter().print("<h1>Status get Updated</h1>");

//here i am going to take the updated information from bank account table

List<Bank_account> list=bankDao.fetchall();
req.getSession().setAttribute("list", list);

req.getRequestDispatcher("adminhome.jsp").include(req, resp);
}
}
