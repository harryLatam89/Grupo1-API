package ues.edu.sv.boltra.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.Contratante;
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

	public List<Vacantes> listarPorContratante(Contratante contratante) {
		return repository.findByContratanteAndActivo(contratante, true);
	}

	public List<Vacantes> listarPorInactivosContratante(Contratante contratante) {
		return repository.findByContratanteAndActivo(contratante, false);
	}

	public List<Vacantes> listarPorOcupadosContratante(Contratante contratante) {
		return repository.findByContratanteAndActivoAndEstado(contratante, true, 3);
	}

	public List<Vacantes> listarActivos() {
		return repository.findByActivo(true);
	}

	public List<Vacantes> listarPorCandidato(Candidato candidato) {
		return repository.findRecomendacionParaCandidato(candidato.getIdCandidato());
	}

}
