package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Rol;
import ues.edu.sv.boltra.api.repository.RolRepository;

@Service
public class RolService extends AbsService<Rol, RolRepository> {

	@Autowired
	private RolRepository repository;

	@Override
	protected RolRepository getRepo() {
		return repository;
	}

}
