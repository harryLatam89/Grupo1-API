package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Administrador;
import ues.edu.sv.boltra.api.repository.AdministradorRepository;

@Service
public class AdministradorService extends AbsService<Administrador, AdministradorRepository> {

	@Autowired
	private AdministradorRepository repository;
	
	@Override
	protected AdministradorRepository getRepo() {
		return repository;
	}
	
}
