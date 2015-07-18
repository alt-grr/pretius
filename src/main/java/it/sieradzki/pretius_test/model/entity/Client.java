package it.sieradzki.pretius_test.model.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Project> projects = new HashSet<>();

	protected Client() {
	}

	public Client(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected Set<Project> getMutableProjects() {
		return projects;
	}

	public Set<Project> getProjects() {
		return Collections.unmodifiableSet(getMutableProjects());
	}

	public void addProject(Project project) {
		getMutableProjects().add(project);
	}
}
