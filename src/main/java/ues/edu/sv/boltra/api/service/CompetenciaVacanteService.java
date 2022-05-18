package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.CompetenciaVacante;
import ues.edu.sv.boltra.api.repository.CompetenciaVacanteRepository;

@Service
public class CompetenciaVacanteService extends AbsService<CompetenciaVacante, CompetenciaVacanteRepository> {

	@Autowired
	private CompetenciaVacanteRepository repository;
	
	@Override
	protected CompetenciaVacanteRepository getRepo() {
		return repository;
	}
	
}
