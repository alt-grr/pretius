package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.entity.Project;
import it.sieradzki.pretius_test.model.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project save(Project entity) {
		return projectRepository.save(entity);
	}

	public Project findOne(Long id) {
		return projectRepository.findOne(id);
	}

	public List<Project> findAll() {
		return projectRepository.findAll();
	}
}
