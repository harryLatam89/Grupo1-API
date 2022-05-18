package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.CompetenciaCandidato;
import ues.edu.sv.boltra.api.repository.CompetenciaCandidatoRepository;

@Service
public class CompetenciaCandidatoService extends AbsService<CompetenciaCandidato, CompetenciaCandidatoRepository> {

	@Autowired
	private CompetenciaCandidatoRepository repository;
	
	@Override
	protected CompetenciaCandidatoRepository getRepo() {
		return repository;
	}
	
}
