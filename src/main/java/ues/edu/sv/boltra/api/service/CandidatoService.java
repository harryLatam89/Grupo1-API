package ues.edu.sv.boltra.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.repository.CandidatoRepository;

@Service
public class CandidatoService extends AbsService<Candidato, CandidatoRepository> {

	@Autowired
	private CandidatoRepository repository;
	
	@Override
	protected CandidatoRepository getRepo() {
		return repository;
	}
	
	public Candidato buscarPorUsuario(Usuario user) {
		List<Candidato> candidatos = getRepo().findByUsuario(user);
		if (candidatos != null && !candidatos.isEmpty()) {
			return candidatos.get(0);
		}
		return null;
	}
	
}
