package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Customer;

public class CustomerDao {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
EntityManager entityManager=entityManagerFactory.createEntityManager();
EntityTransaction entityTransaction=entityManager.getTransaction();

public void save(Customer customer)
{
entityTransaction.begin();
entityManager.persist(customer);
entityTransaction.commit();
}
public List<Customer> check1(String Email)
{
List<Customer> list=entityManager.createQuery("select x from Customer x where Email=?1").setParameter(1, Email).getResultList();
return list;
}


public List<Customer> check2(long mob)
{
List<Customer> list=entityManager.createQuery("select x from Customer x where Mobile=?1").setParameter(1, mob).getResultList();
return list;
}


public Customer login(int customerid) {
	Customer customer=entityManager.find(Customer.class, customerid);
	return customer;
}
public void update(Customer customer) {
	entityTransaction.begin();
	entityManager.merge(customer);
	entityTransaction.commit();
	
	
}
}
