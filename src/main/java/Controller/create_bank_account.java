package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import Dao.BankDao;
import Dao.CustomerDao;
import Dto.Bank_account;
import Dto.Customer;

@WebServlet("/createaccounttype")
public class create_bank_account extends HttpServlet 

{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String acc_type=req.getParameter("accounttype");
	Customer customer=(Customer) req.getSession().getAttribute("customer");
	
	List<Bank_account> list=customer.getBankaccounts();
	boolean flag=true;
	
	for (Bank_account bank_account : list) 
	{
	if( bank_account.getAccount_type().equals(acc_type))
	{
		flag=false;
		break;
	}
	}
	
	
	if(flag==true)
	{
		Bank_account bank_account1 =new Bank_account();
		//bank_account1.setAcc_no(0);
		//bank_account1.setStatus(flag);
		//bank_account1.setAmount(0);
		bank_account1.setAccount_type(acc_type);
		
		
		
		if(bank_account1.getAccount_type().equals("saving"))
		
			bank_account1.setAcc_limit(100000);
		
		else 
			bank_account1.setAcc_limit(200000);
			 bank_account1.setCustomer(customer);
			   BankDao bankDao=new BankDao();
			   bankDao.save_account(bank_account1);
			   
			   List<Bank_account> list2= list;
			   list2.add(bank_account1);
			   customer.setBankaccounts(list2);
			   
			   
			   CustomerDao customerDao=new CustomerDao();
			   customerDao.update(customer);
			   
				resp.getWriter().print("<h1>Congratulation Your Account has been created Sucessfully</h1>");
		
	}
	else {
		resp.getWriter().print("<h1>Already account is Existed</h1>");
		}
	}
	}
	


