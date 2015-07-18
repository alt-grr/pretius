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


	private static final String[] TASK_NAME_PART_1 =
			new String[]{"Pilne", "Mało ważne", "Kluczowe", "Opcjonalne", "Złożone", "Trudne"};


	private static final String[] FIRST_NAMES = new String[]{
			"Jan",
			"Filip",
			"Mikołaj",
			"Bartek",
			"Jakub",
			"Adam",
			"Antoni",
			"Franciszek",
			"Mateusz",
			"Aleksander",
			"Ignacy",
			"Michał",
			"Piotr",
			"Stanisław",
			"Szymon",
			"Wiktor",
			"Kacper",
			"Maksymilian",
			"Kamil",
			"Krzysztof"
	};

	private static final String[] LAST_NAMES = new String[]{
			"Nowak",
			"Kowalski",
			"Wiśniewski",
			"Dąbrowski",
			"Lewandowski",
			"Wójcik",
			"Kamiński",
			"Kowalczyk",
			"Zieliński",
			"Szymański",
			"Woźniak",
			"Kozłowski",
			"Jankowski",
			"Wojciechowski",
			"Kwiatkowski",
			"Kaczmarek",
			"Mazur",
			"Krawczyk",
			"Piotrowski",
			"Grabowski"
	};

	public String getProjectName() {
		return PROJECT_NAME_PART_1[RANDOM.nextInt(PROJECT_NAME_PART_1.length)] + ' ' +
				PROJECT_NAME_PART_2[RANDOM.nextInt(PROJECT_NAME_PART_2.length)] + ' ' +
				PROJECT_NAME_PART_3[RANDOM.nextInt(PROJECT_NAME_PART_3.length)] + ' ' + (1 + RANDOM.nextInt(100));
	}

	public String getTaskName() {
		return TASK_NAME_PART_1[RANDOM.nextInt(TASK_NAME_PART_1.length)] + " zadanie nr " + (1 + RANDOM.nextInt(100));
	}

	public String getFirstName() {
		return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
	}

	public String getLastName() {
		return LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
	}
}
