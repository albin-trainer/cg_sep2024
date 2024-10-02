package com.cg;

import java.util.List;
import java.util.function.Consumer;

import com.cg.entity.Address;
import com.cg.entity.Customer;
import com.cg.entity.Gender;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomerDAO {
	static EntityManagerFactory emf=
			Persistence.createEntityManagerFactory("jpaPU");//reads META-INF/persistence.xml
public static void main(String[] args) {
	System.out.println("TEST...");
	//addNewCustomer();
	searchCustomerById(102);
	//updateEmail(102,"sanjay@cg.com");
	//getAllCustomers();
	//getCustomersBycity("Bengaluru");
}
private static void getCustomersBycity(String city) {
	EntityManager em=emf.createEntityManager();
	//:paramname => named parameter
	String jpql="select c from Customer c where c.address.placeName = :p";
	//import from jakarka.persistence
	Query q=em.createQuery(jpql);
	q.setParameter("p", city);
	//java.util.List
	List<Customer> clist=q.getResultList();
	Consumer<Customer>consumer=
			c->System.out.println(c.getCustName()+"\t"+c.getEmail()+"\t"+c.getAddress().getDoorNo()+" "+c.getAddress().getPlaceName());
			
	clist.forEach(consumer);	
}
private static void getAllCustomers() {
	EntityManager em=emf.createEntityManager();
	String jpql="select c from Customer c";
	//import from jakarka.persistence
	Query q=em.createQuery(jpql);
	//java.util.List
	List<Customer> clist=q.getResultList();
	Consumer<Customer>consumer=c->System.out.println(c.getCustName()+"\t"+c.getEmail());
	clist.forEach(consumer);
}
private static void searchCustomerById(int custId) {
	EntityManager em=emf.createEntityManager();
	Customer c=  em.find(Customer.class, custId);//search by only PK
	System.out.println("---");
	Customer c2=  em.find(Customer.class, custId);//search by only PK

	if(c!=null) {
		//display the address toooo
		System.out.println(c.getCustName()+" "+c.getEmail());
	}
	else
		System.out.println("Not found ....");
}
static void updateEmail(int custId,String newEmail) {
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	Customer c=em.find(Customer.class, custId);//Managed state....
	if(c!=null) 
		c.setEmail(newEmail);
	else
		System.out.println("Not found ....");
	em.getTransaction().commit();
}
static void remove(int custId) {
	//do it .......
}
static void addNewCustomer() {
	Address addr=new  Address();
	addr.setDoorNo("E-109");
	addr.setPlaceName("Hyderabad");
    addr.setPinCode(560090);	
	Customer c1=new Customer(); //new or transient state....
	c1.setCustId(105);
	c1.setCustName("Sudheer");
	c1.setGender(Gender.Male);
	c1.setEmail("Sudheer@cg.com");
	c1.setAddress(addr);
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();//to start the transaction
	em.persist(c1); //saving in the DB(Managed state)
//	addr.setPlaceName("WhiteField Bengaluru");
	//c1.setEmail("sanjay@abc.com");
	em.getTransaction().commit(); //Detached ....
	//c1.setEmail("sanjay@gmail.com"); //
	System.out.println("ADDED :)");
}

}
