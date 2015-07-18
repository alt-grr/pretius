package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.entity.Task;
import it.sieradzki.pretius_test.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task save(Task entity) {
		return taskRepository.save(entity);
	}

	public List<Task> save(Iterable<Task> entities) {
		return taskRepository.save(entities);
	}

	public Task findOne(Long id) {
		return taskRepository.findOne(id);
	}

	public List<Task> findAll() {
		return taskRepository.findAll();
	}
}
