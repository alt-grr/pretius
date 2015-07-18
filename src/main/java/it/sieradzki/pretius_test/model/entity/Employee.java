package it.sieradzki.pretius_test.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<HoursWorked> hoursWorkedList = new ArrayList<>();

	protected Employee() {
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
