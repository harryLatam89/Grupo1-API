package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Vacantes;
import ues.edu.sv.boltra.api.repository.VacanteRepository;

@Service
public class VacanteService extends AbsService<Vacantes, VacanteRepository> {

	@Autowired
	private VacanteRepository repository;
	
	@Override
	protected VacanteRepository getRepo() {
		return repository;
	}
	
}
