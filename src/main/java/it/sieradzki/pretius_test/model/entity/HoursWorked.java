package it.sieradzki.pretius_test.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hours_worked")
public class HoursWorked {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "working_day", nullable = false)
	private LocalDate workingDay;

	@Column(name = "hours_worked", nullable = false)
	private int hoursWorked;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	protected HoursWorked() {
	}

	public HoursWorked(LocalDate workingDay, int hoursWorked, Employee employee, Task task) {
		this.workingDay = workingDay;
		this.hoursWorked = hoursWorked;
		this.employee = employee;
		this.task = task;
	}

	public LocalDate getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(LocalDate workingDay) {
		this.workingDay = workingDay;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "HoursWorked{" +
				"id=" + id +
				", workingDay=" + workingDay +
				", hoursWorked=" + hoursWorked +
				", employee=" + employee +
				", task=" + task +
				'}';
	}
}
