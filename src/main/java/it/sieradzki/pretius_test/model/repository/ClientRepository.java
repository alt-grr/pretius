package it.sieradzki.pretius_test.model.repository;

import it.sieradzki.pretius_test.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
