package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.dto.ReportRowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

	@Autowired
	private JdbcOperations jdbcOperations;

	public List<ReportRowDto> getReport() {

		// TODO

		return null;
	}
}
