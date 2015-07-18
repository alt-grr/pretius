package it.sieradzki.pretius_test.generator;

import it.sieradzki.pretius_test.model.entity.Client;
import it.sieradzki.pretius_test.model.entity.Project;
import it.sieradzki.pretius_test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Generator {

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

		List<Client> clients = generateClients();
		for (Client client : clients) {
			for (int i = 0; i < 5; i++) {
				Project project = new Project(randomNames.getProjectName());
				project.setClient(client);
				client.addProject(project);
			}
		}
		clientService.save(clients);
	}

	private List<Client> generateClients() {

		List<Client> clients = new ArrayList<>(5);

		clients.add(new Client("nc+"));
		clients.add(new Client("Play"));
		clients.add(new Client("RWE"));
		clients.add(new Client("TVN"));
		clients.add(new Client("Polkomtel"));

		return clients;
	}
}
