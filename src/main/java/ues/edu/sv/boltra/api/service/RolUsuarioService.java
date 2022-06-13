package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.RolUsuario;
import ues.edu.sv.boltra.api.repository.RolUsuarioRepository;

@Service
public class RolUsuarioService extends AbsService<RolUsuario, RolUsuarioRepository> {

	@Autowired
	private RolUsuarioRepository repository;

	@Override
	protected RolUsuarioRepository getRepo() {
		return repository;
	}

}
