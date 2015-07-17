package it.sieradzki.pretius_test.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<HoursWorked> hoursWorkedList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected List<HoursWorked> getMutableHoursWorkedList() {
		return hoursWorkedList;
	}

	public List<HoursWorked> getHoursWorkedList() {
		return Collections.unmodifiableList(getMutableHoursWorkedList());
	}

	public void addHoursWorked(HoursWorked hoursWorked) {
		getMutableHoursWorkedList().add(hoursWorked);
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
