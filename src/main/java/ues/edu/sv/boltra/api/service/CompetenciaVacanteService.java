package ues.edu.sv.boltra.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.CompetenciaVacante;
import ues.edu.sv.boltra.api.models.Competencias;
import ues.edu.sv.boltra.api.models.Vacantes;
import ues.edu.sv.boltra.api.repository.CompetenciaVacanteRepository;

@Service
public class CompetenciaVacanteService extends AbsService<CompetenciaVacante, CompetenciaVacanteRepository> {

	@Autowired
	private CompetenciaVacanteRepository repository;

	@Override
	protected CompetenciaVacanteRepository getRepo() {
		return repository;
	}

	public List<Competencias> listarPorVacante(Vacantes vacante) {
		List<Competencias> list = new ArrayList<>();
		List<CompetenciaVacante> found = repository.findByVacante(vacante);
		if (found != null && !found.isEmpty())
			found.forEach(comp -> list.add(comp.getCompetencia()));
		return list;
	}

}
