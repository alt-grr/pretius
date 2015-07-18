package it.sieradzki.pretius_test.generator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNames {

	private static final Random RANDOM = new Random();

	private static final String[] PROJECT_NAME_PART_1 =
			new String[]{"Stworzenie", "Utrzymanie", "Rozbudowa", "Integracja", "Przepisanie", "Testy"};

	private static final String[] PROJECT_NAME_PART_2 =
			new String[]{"systemu", "projektu", "modułu", "portalu", "testu", "skryptu"};

	private static final String[] PROJECT_NAME_PART_3 =
			new String[]{"płatności", "księgowego", "aukcyjnego", "ogłoszeniowego", "rekrutacyjnego"};

	public String getProjectName() {
		return PROJECT_NAME_PART_1[RANDOM.nextInt(PROJECT_NAME_PART_1.length)] + ' ' +
				PROJECT_NAME_PART_2[RANDOM.nextInt(PROJECT_NAME_PART_2.length)] + ' ' +
				PROJECT_NAME_PART_3[RANDOM.nextInt(PROJECT_NAME_PART_3.length)];

	}
}
