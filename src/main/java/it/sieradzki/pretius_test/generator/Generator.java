package it.sieradzki.pretius_test.generator;

import com.google.common.collect.Iterables;
import it.sieradzki.pretius_test.model.entity.*;
import it.sieradzki.pretius_test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class Generator {

	private static final int EMPLOYEES_NUMBER = 20;

	private static final int PROJECTS_NUMBER = 5;

	private static final int TASKS_NUMBER = 5;

	private static final int DAYS_WORKED_ON_TASK = 180;

	private static final int EMPLOYEES_WORKED_ON_TASK = 3;

	private static final int DAYS_TO_SKIP_ON_TASK = 4;

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
		Iterator<Employee> cyclicEmployees = Iterables.cycle(employees).iterator();

		Random random = new Random();
		for (Task task : tasks) {

			LocalDate date = LocalDate.now().minusDays(DAYS_WORKED_ON_TASK);
			for (int i = 0; i < DAYS_WORKED_ON_TASK; i++) {

				for (int j = 0; j < EMPLOYEES_WORKED_ON_TASK; j++) {

					Employee employeeForTask = cyclicEmployees.next();
					HoursWorked hoursWorked = new HoursWorked(date, 1 + random.nextInt(8), employeeForTask, task);
					task.addHoursWorked(hoursWorked);
					employeeForTask.addHoursWorked(hoursWorked);
				}

				date = date.plusDays(DAYS_TO_SKIP_ON_TASK);
			}
		}

		taskService.save(tasks);
		employeeService.save(employees);
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
