package it.sieradzki.pretius_test.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Task> tasks = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected List<Task> getMutableTasks() {
		return tasks;
	}

	public List<Task> getTasks() {
		return Collections.unmodifiableList(getMutableTasks());
	}

	public void addTask(Task task) {
		getMutableTasks().add(task);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
