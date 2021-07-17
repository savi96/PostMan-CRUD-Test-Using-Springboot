package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager; 


import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entitymanager; 	//get current session in jpa
	
	
	@Override
	public List<Employee> get() {
	
			Session currentSession = entitymanager.unwrap(Session.class);
			Query<Employee> query = currentSession.createQuery("from Employee",Employee.class); 
			System.out.println(query);
			List<Employee> list = query.getResultList();
			System.out.println(list);
			return list;
		
		
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Employee employeeobj = currentSession.get(Employee.class,id);
		return employeeobj;
		
	}

//	//only used to save
//	@Override
//	public void save(Employee employee) {
//		Session currentSession = entitymanager.unwrap(Session.class);
//		currentSession.save(employee);
		
//	}
	
	@Override
	public void save(Employee employee) {
		Session currentSession = entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
		
	} 

	@Override
	public void delete(int id) {
		Session currentSession = entitymanager.unwrap(Session.class);
		Employee employeeobj = currentSession.get(Employee.class,id);
		currentSession.delete(employeeobj);
		
	}

}
