package it.sieradzki.pretius_test.service;

import it.sieradzki.pretius_test.model.entity.HoursWorked;
import it.sieradzki.pretius_test.model.repository.HoursWorkedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HoursWorkedService {

	@Autowired
	private HoursWorkedRepository hoursWorkedRepository;

	public HoursWorked save(HoursWorked entity) {
		return hoursWorkedRepository.save(entity);
	}

	public HoursWorked findOne(Long id) {
		return hoursWorkedRepository.findOne(id);
	}

	public List<HoursWorked> findAll() {
		return hoursWorkedRepository.findAll();
	}

	public Page<HoursWorked> findAll(Pageable pageable) {
		return hoursWorkedRepository.findAll(pageable);
	}
}
