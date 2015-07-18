package it.sieradzki.pretius_test.model.dto;

import java.time.YearMonth;

public class ReportRowDto {

	private final String clientName;

	private final String projectName;

	private final int totalHoursWorked;

	private final YearMonth yearMonth;

	public ReportRowDto(String clientName, String projectName, int totalHoursWorked, YearMonth yearMonth) {
		this.clientName = clientName;
		this.projectName = projectName;
		this.totalHoursWorked = totalHoursWorked;
		this.yearMonth = yearMonth;
	}

	public String getClientName() {
		return clientName;
	}

	public String getProjectName() {
		return projectName;
	}

	public int getTotalHoursWorked() {
		return totalHoursWorked;
	}

	public YearMonth getYearMonth() {
		return yearMonth;
	}

	@Override
	public String toString() {
		return "ReportDto{" +
				"clientName='" + clientName + '\'' +
				", projectName='" + projectName + '\'' +
				", totalHoursWorked=" + totalHoursWorked +
				", yearMonth=" + yearMonth +
				'}';
	}
}
