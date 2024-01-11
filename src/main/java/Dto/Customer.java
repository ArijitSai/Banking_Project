package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@javax.persistence.Entity

public class Customer {

	@Id
	@SequenceGenerator(initialValue = 11223345,allocationSize = 1,sequenceName = "CustomerId",name="CustomerId")
	@GeneratedValue(generator = "CustomerId")//here this annotation will be used to generate the id
	int cid;
	
	
	String Cname;
	
	long Mobile;
	
	String Password;
	
	String Email;
	
	String Gender;
	
	Date date;
	
	@OneToMany
	List<Bank_account>bankaccounts;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public long getMobile() {
		return Mobile;
	}

	public void setMobile(long mobile) {
		Mobile = mobile;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Bank_account> getBankaccounts() {
		return bankaccounts;
	}

	public void setBankaccounts(List<Bank_account> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
}
