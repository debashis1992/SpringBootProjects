package com.debashis.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/addEmp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return ResponseEntity.status(HttpStatus.OK).body("Employee was added.");
	}
	
	@PostMapping("/getEmpById/{id}")
	public ResponseEntity<String> getEmpById(@PathVariable Integer id) {
		if(employeeRepository.findById(id)!=null) {
			Optional<Employee> emp = employeeRepository.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(emp.toString());
		}
		else return ResponseEntity.status(HttpStatus.OK).body("Not found");
	
	}
	
	@PostMapping("/deleteEmpById/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable Integer id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		employeeRepository.delete(emp.get());
		return ResponseEntity.status(HttpStatus.OK).body("Employee was deleted");
	}
	@GetMapping("/count")
	public ResponseEntity<String> getCount() {
		return ResponseEntity.status(HttpStatus.OK).body("Total count is : "+employeeRepository.count());
	}
	
	@PostMapping("/countByName/{name}")
	public ResponseEntity<String> getCountByName(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body("Count by "+name+" is : "+employeeRepository.countByName(name));
	}
	
	
	@PostMapping("/findByName/{name}")
	public ResponseEntity<String> findByName(@PathVariable String name) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByName(name);
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@PostMapping("/findByEmployer/{employer}")
	public ResponseEntity<String> findByEmployer(@PathVariable String employer) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByEmployer(employer);
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@PostMapping("/findByEmployerLike/{employer}")
	public ResponseEntity<String> findByEmployerIsLike(@PathVariable String employer) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByEmployerContaining(employer);
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@PostMapping("/findByNameIsLike/{name}")
	public ResponseEntity<String> findByNameIsLike(@PathVariable String name) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByNameContaining(name);
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@GetMapping("/findAllOrderByNameAsc")
	public ResponseEntity<String> findAllOrderByNameAsc() {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findAllByOrderByNameAsc();
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@GetMapping("/findAllOrderByEmployerDesc")
	public ResponseEntity<String> findAllOrderByEmployerDesc() {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findAllByOrderByEmployerDesc();
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@PostMapping("/findByNameAndEmployer/{name}/{employer}")
	public ResponseEntity<String> findByNameAndEmployer(@PathVariable String name,@PathVariable String employer) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByNameAndEmployer(name,employer);
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	
	@PostMapping("/findByIdLessThan/{id}")
	public ResponseEntity<String> findByNameAndEmployer(@PathVariable String id) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByIdLessThan(Integer.parseInt(id));
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	@PostMapping("/findByNameLikeOrderByEmployerDesc/{name}")
	public ResponseEntity<String> findByNameLikeOrderByEmployerDesc(@PathVariable String name) {
		StringBuilder sb = new StringBuilder();
		List<Employee> list = employeeRepository.findByNameContainingOrderByEmployerDesc(name);
		Iterator<Employee> it = list.iterator();
		while(it.hasNext()) {
			sb.append(it.next()+"\n");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
	}
	
	
}
