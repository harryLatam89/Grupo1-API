package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.repository.ContratanteRepository;

@Service
public class ContratanteService extends AbsService<Contratante, ContratanteRepository> {

	@Autowired
	private ContratanteRepository repository;
	
	@Override
	protected ContratanteRepository getRepo() {
		return repository;
	}
	
}
