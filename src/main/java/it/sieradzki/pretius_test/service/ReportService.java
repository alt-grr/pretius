package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.dto.ReportRowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class ReportService {

	@Autowired
	private JdbcOperations jdbcOperations;

	public List<ReportRowDto> getReport() {

		String sql = "SELECT " +
				"clients.name AS client_name, " +
				"projects.id AS project_id, " +
				"projects.name AS project_name, " +
				"EXTRACT(YEAR FROM hours_worked.working_day) AS working_year, " +
				"EXTRACT(MONTH FROM hours_worked.working_day) AS working_month, " +
				"SUM(hours_worked.hours_worked) AS hours_worked_in_year_month " +
				"FROM projects " +
				"JOIN clients ON projects.client_id = clients.id " +
				"JOIN tasks ON projects.id = tasks.project_id " +
				"JOIN hours_worked ON tasks.id = hours_worked.task_id " +
				"GROUP BY project_id, working_year, working_month " +
				"ORDER BY working_year ASC, working_month ASC, client_name ASC, project_name ASC";

		return jdbcOperations.query(sql, (rs, rowNum) -> {
			return new ReportRowDto(rs.getString("client_name"), rs.getString("project_name"),
					rs.getInt("hours_worked_in_year_month"),
					YearMonth.of(rs.getInt("working_year"), rs.getInt("working_month")));
		});
	}
}
