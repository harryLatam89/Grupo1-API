package ues.edu.sv.boltra.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.repository.ContratanteRepository;

@Service
public class ContratanteService extends AbsService<Contratante, ContratanteRepository> {

	@Autowired
	private ContratanteRepository repository;

	@Override
	protected ContratanteRepository getRepo() {
		return repository;
	}

	public Contratante buscarPorUsuario(Usuario user) {
		List<Contratante> candidatos = getRepo().findByUsuario(user);
		if (candidatos != null && !candidatos.isEmpty()) {
			return candidatos.get(0);
		}
		return null;
	}

}
