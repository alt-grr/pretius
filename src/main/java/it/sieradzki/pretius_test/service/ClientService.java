package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.entity.Client;
import it.sieradzki.pretius_test.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client save(Client entity) {
		return clientRepository.save(entity);
	}

	public List<Client> save(Iterable<Client> entities) {
		return clientRepository.save(entities);
	}

	public Client findOne(Long id) {
		return clientRepository.findOne(id);
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}
}
