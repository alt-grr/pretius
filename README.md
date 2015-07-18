# pretius
Zadanie rekrutacyjne do firmy Pretius.

# Wymagania
- Java 8
- Maven 3

# Wykorzystane technologie
- Spring Framework
- Spring Security
- Spring Data JPA, [JdbcTemplate][1]
- Hibernate
- H2
- Bootstrap 
- Jetty

# Instrukcja obsługi
1. W głównym katalogu projektu uruchom komendę: `mvn compile jetty:run`  
2. Po wyświetleniu się na konsoli wiadomości `[INFO] Started Jetty Server` otwórz w przegladarce adres
[http://localhost:8080/](http://localhost:8080/)
3. Zaloguj się do aplikacji podając login `user` oraz hasło `password`
4. Przeczytaj wygenerowany raport.

[1]: https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
