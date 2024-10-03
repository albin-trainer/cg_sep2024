package com.cg.entity;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	static EntityManagerFactory emf=
			Persistence.createEntityManagerFactory("jpaPU");
	public static void main(String[] args) {
		print();
		//addStudent();
	}
	public static void addStudent() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Address a=new Address();
		a.setAddrid(102);
		a.setPlace("Blr");
		
		Student s=new Student();
		s.setId(2);
		s.setSname("B");
		s.setAddress(a);
		a.setStudent(s);
		em.persist(s);
		em.getTransaction().commit();
	}
public static void print() {
	EntityManager em=emf.createEntityManager();
	Student s=em.find(Student.class, 2);
	System.out.println(s.getSname());
	System.out.println(s.getAddress().getPlace());
}
public static void removeStudent() {
	EntityManager em=emf.createEntityManager();

	Student s=em.find(Student.class, 1);
	em.remove(s);
	em.getTransaction().commit();
}
}
