package com.cg.entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class EmpRepo {
	@PersistenceContext
	private EntityManager em;
@Transactional
	public  void addStudent() {
		Address a=new Address();
		a.setAddrid(101);
		a.setPlace("Blr");
		
		Student s=new Student();
		s.setId(1);
		s.setSname("A");
		s.setAddress(a);
		a.setStudent(s);
		em.persist(s);
	}
public void print() {
	Student s=em.find(Student.class, 1);
	System.out.println(s.getSname());
	System.out.println(s.getAddress().getPlace());
}
@Transactional
public void removeStudent() {
	Student s=em.find(Student.class, 1);
	em.remove(s);
}
}
