package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.entity.Employee;
import it.sieradzki.pretius_test.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee entity) {
		return employeeRepository.save(entity);
	}

	public List<Employee> save(Iterable<Employee> entities) {
		return employeeRepository.save(entities);
	}

	public Employee findOne(Long id) {
		return employeeRepository.findOne(id);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
}
