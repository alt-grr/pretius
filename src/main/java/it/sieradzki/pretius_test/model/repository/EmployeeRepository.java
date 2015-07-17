package it.sieradzki.pretius_test.model.repository;

import it.sieradzki.pretius_test.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
