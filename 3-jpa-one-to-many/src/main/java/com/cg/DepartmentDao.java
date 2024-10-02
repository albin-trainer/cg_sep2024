package com.cg;

import java.util.List;

import com.cg.entity.Department;
import com.cg.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DepartmentDao {
	static EntityManagerFactory emf=
			Persistence.createEntityManagerFactory("jpaPU");
public static void main(String[] args) {
	System.out.println("TEST");
	//addNewDepartment();
//	Employee e=new Employee();
//	e.setEmpId(105);
//	e.setEmpName("Aravind");
//	e.setSalary(40000);
//	addNewEmployee(e,10002);
	getEmpDetails(101);
	//getEmpDetailsByDeptId(10001);
	//getEmpDetailsByDeptIdByJQPL(10001);
}
private static void getEmpDetailsByDeptIdByJQPL(int deptId) {
	EntityManager em=emf.createEntityManager();
	String jpql="select e from Employee e where e.dept.deptId= :id";
	Query q=em.createQuery(jpql);
	q.setParameter("id", deptId);
	List<Employee> emps=q.getResultList();
	emps.forEach(c->System.out.println(c.getEmpId()+"\t"+c.getEmpName()));
}
static void getEmpDetailsByDeptId(int deptId) {
	EntityManager em=emf.createEntityManager();
	//named parameter (:paramname)
	String sql="select * from employee where deptId= :id";
	Query q=em.createNativeQuery(sql,Employee.class);
	q.setParameter("id", deptId);
	List<Employee> emps=q.getResultList();
	emps.forEach(c->System.out.println(c.getEmpId()+"\t"+c.getEmpName()));
}
static void getEmpDetails(int empId) {
	//display the emp details such as name, salary & the dept name 
	EntityManager em=emf.createEntityManager();
	Employee e=em.find(Employee.class, empId);
	if(e!=null) {
		System.out.println(e.getEmpName()+" "+e.getSalary());
		System.out.println(e.getDept().getDeptName());
	}
}
private static void addNewEmployee(Employee e,int deptId) {
	EntityManager em=emf.createEntityManager();
	Department d=em.find(Department.class, deptId);
    if(d!=null) {
    	//mapping bw Emp and Dep happens here..
    	e.setDept(d);
    	em.getTransaction().begin();
    	em.persist(e);
    	em.getTransaction().commit();
    	System.out.println("Emp added");
    }
    else {
    	System.out.println("Incorrect Dept id ");
    }
}
static void addNewDepartment() {
	//pls do the implementation
	//Only Department NOT Employee
	Department d=new Department();
	d.setDeptId(10002);
	d.setDeptName("Accounts");
	EntityManager em=emf.createEntityManager();
	em.getTransaction().begin();
	em.persist(d);
	em.getTransaction().commit();
	System.out.println("Department Saved");
}
}
