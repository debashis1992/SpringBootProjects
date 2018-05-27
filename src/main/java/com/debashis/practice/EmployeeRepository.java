package com.debashis.practice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findById(int id); 
	
	public List<Employee> findAll();
	
	public long count();
	
	public List<Employee> findByName(String name);
	
	public List<Employee> findByEmployer(String employer);
	
	public long countByName(String name);
	
	public List<Employee> findByNameContaining(String name);
	
	public List<Employee> findByEmployerContaining(String employer);
	
	public List<Employee> findAllByOrderByNameAsc();
	
	public List<Employee> findAllByOrderByEmployerDesc();
	
	public List<Employee> findByNameAndEmployer(String name,String employer);
	
	public List<Employee> findByIdLessThan(int id);
	
	public List<Employee> findByNameContainingOrderByEmployerDesc(String name);
}
