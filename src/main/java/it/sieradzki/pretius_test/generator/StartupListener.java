package it.sieradzki.pretius_test.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartupListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);

	@Autowired
	private Generator generator;

	@PostConstruct
	private void afterStartup() {
		LOGGER.info("Generating and saving random data to database started...");

		generator.generateAndSaveRandomData();
	}
}
