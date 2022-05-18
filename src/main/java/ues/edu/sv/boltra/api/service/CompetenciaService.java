package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Competencias;
import ues.edu.sv.boltra.api.repository.CompetenciaRepository;

@Service
public class CompetenciaService extends AbsService<Competencias, CompetenciaRepository> {

	@Autowired
	private CompetenciaRepository repository;
	
	@Override
	protected CompetenciaRepository getRepo() {
		return repository;
	}
	
}
