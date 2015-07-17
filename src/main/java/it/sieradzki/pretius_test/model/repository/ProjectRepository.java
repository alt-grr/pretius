package it.sieradzki.pretius_test.model.repository;

import it.sieradzki.pretius_test.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
