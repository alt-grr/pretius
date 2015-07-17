package it.sieradzki.pretius_test.model.repository;

import it.sieradzki.pretius_test.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
