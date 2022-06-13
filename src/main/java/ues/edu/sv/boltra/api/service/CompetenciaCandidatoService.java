package ues.edu.sv.boltra.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.CompetenciaCandidato;
import ues.edu.sv.boltra.api.models.Competencias;
import ues.edu.sv.boltra.api.repository.CompetenciaCandidatoRepository;

@Service
public class CompetenciaCandidatoService extends AbsService<CompetenciaCandidato, CompetenciaCandidatoRepository> {

	@Autowired
	private CompetenciaCandidatoRepository repository;

	@Override
	protected CompetenciaCandidatoRepository getRepo() {
		return repository;
	}

	public List<Competencias> buscarPorCandidato(Candidato candidato) {
		List<Competencias> list = new ArrayList<>();
		List<CompetenciaCandidato> found = repository.findByCandidato(candidato);
		if (found != null && !found.isEmpty())
			found.forEach(comp -> list.add(comp.getCompetencia()));
		return list;
	}

}
