package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dto.Customer;

@WebServlet("/customersignup")
public class Customersignup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name = req.getParameter("name");
		String MobileNo = req.getParameter("mob");

		long mob = Long.parseLong(MobileNo);

		String Password = req.getParameter("pwd");
		String Email = req.getParameter("email");
		String Gender = req.getParameter("gender");
		String DateOfBirth = req.getParameter("dob");

		Date date = Date.valueOf(DateOfBirth);//here it is indicating that we have converted sucessfully string value to dqate value

		Period period = Period.between(date.toLocalDate(), LocalDate.now());
		int age = period.getYears();
		Customer customer=new Customer();
		CustomerDao customerDao=new CustomerDao();
		if (age >= 18) {
			
			if(customerDao.check1(Email).isEmpty() && customerDao.check2(mob).isEmpty())
			{
//			resp.getWriter().print("<h1>He is Eligible to Create Bank Account</h1>");
			customer.setCname(Name);
			customer.setMobile(mob);
			customer.setPassword(Password);
			customer.setEmail(Email);
			customer.setGender(Gender);
			customer.setDate(date);
			
			customerDao.save(customer);
			Customer customer2=customerDao.check1(Email).get(0);
			
			if(customer2.getGender().equals("female"))
			{
				resp.getWriter().print("<h1>Hello Madam</h1>");
			}
			else {
				resp.getWriter().print("<h1>Hello Sir</h1>");
			}
			resp.getWriter().print("<h1>Account has been creeated sucessfully your customer id is:"+customer2.getCid()+"</h1>");
		} 
		
	
		else {
			resp.getWriter().print("<h1>This email id:"+Email+"and this mobile no:"+mob+" is already existed"+"</h1>");
		}
		}
		else 
		{
			resp.getWriter().print("<h1>He is not Eligible to Create Bank Account</h1>");
		}
}
}
