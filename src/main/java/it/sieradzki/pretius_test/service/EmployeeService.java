package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.entity.Employee;
import it.sieradzki.pretius_test.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}
}
