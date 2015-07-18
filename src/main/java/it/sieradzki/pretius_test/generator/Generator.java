package it.sieradzki.pretius_test.generator;

import it.sieradzki.pretius_test.model.entity.Client;
import it.sieradzki.pretius_test.model.entity.Employee;
import it.sieradzki.pretius_test.model.entity.Project;
import it.sieradzki.pretius_test.model.entity.Task;
import it.sieradzki.pretius_test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Generator {

	private static final int EMPLOYEES_NUMBER = 20;

	private static final int PROJECTS_NUMBER = 5;

	private static final int TASKS_NUMBER = 5;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private HoursWorkedService hoursWorkedService;

	@Autowired
	private EmployeeService employeeService;


	@Autowired
	private RandomNames randomNames;

	public void generateAndSaveRandomData() {

		// Clients and Projects

		List<Client> clients = generateClientsList();
		for (Client client : clients) {
			for (int i = 0; i < PROJECTS_NUMBER; i++) {
				Project project = new Project(randomNames.getProjectName());
				project.setClient(client);
				client.addProject(project);
			}
		}
		clientService.save(clients);


		// Projects and Tasks

		List<Project> projects = projectService.findAll();
		for (Project project : projects) {
			for (int i = 0; i < TASKS_NUMBER; i++) {
				Task task = new Task(randomNames.getTaskName());
				task.setProject(project);
				project.addTask(task);
			}
		}
		projectService.save(projects);


		// Employees

		List<Employee> employees = new ArrayList<>(EMPLOYEES_NUMBER);
		for (int i = 0; i < EMPLOYEES_NUMBER; i++) {
			employees.add(new Employee(randomNames.getFirstName(), randomNames.getLastName()));
		}
		employees = employeeService.save(employees);


		// Employees, Task and HoursWorked
		List<Task> tasks = taskService.findAll();
		// TODO
	}

	private List<Client> generateClientsList() {

		List<Client> clients = new ArrayList<>(5);

		clients.add(new Client("nc+"));
		clients.add(new Client("Play"));
		clients.add(new Client("RWE"));
		clients.add(new Client("TVN"));
		clients.add(new Client("Polkomtel"));

		return clients;
	}
}
