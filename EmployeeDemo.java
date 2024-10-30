package com.demo;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
@Entity
class Employee
{
	@Id
	private int id;
	private String name;
	private int age;
	private String address;
	
	public Employee() 
	{
		super();
	}

	public Employee(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
class EmployeeDemo{

	public static void main(String[] args) {
		
		// create connection object
				Configuration c = new Configuration();
				//load configuration
				c.configure("hibernate.cfg.xml");
				
				//build a session factory
				SessionFactory sf = c.buildSessionFactory();
				
				//open a session for the session factory
				Session s = sf.openSession();
				
				//Begin a transaction
				Transaction t= s.beginTransaction();
				
				//Instance of Employee class
				Employee e1 = new Employee();
				Employee e2 = new Employee();
				Employee e3 = new Employee();
				
				//Set the value of id, name, age, address
				e1.setId(10); e1.setName("Ruhi"); e1.setAge(28); e1.setAddress("Pune");
				e2.setId(11); e2.setName("Rohit"); e2.setAge(27); e2.setAddress("Mumbai");
				e3.setId(12); e3.setName("Lucy"); e3.setAge(29); e3.setAddress("Bihar");
				
				//save the Employee object
				s.save(e1);
				s.save(e2);
				s.save(e3);
				
				//created to list for employee
				List<Employee> employees = s.createQuery("from Employee", Employee.class).list();

		        System.out.println("List of Employees:");
		        //for aech loop to get the value 
		        for (Employee em : employees) {
		            System.out.println(em.getId());
		            System.out.println(em.getName());
		            System.out.println(em.getAge());
		            System.out.println(em.getAddress());
		        }

				
				//commit the transaction
				t.commit();
				//close the session
				s.close();
	}

}
