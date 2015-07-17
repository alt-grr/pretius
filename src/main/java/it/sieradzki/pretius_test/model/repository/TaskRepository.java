package it.sieradzki.pretius_test.model.repository;

import it.sieradzki.pretius_test.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
