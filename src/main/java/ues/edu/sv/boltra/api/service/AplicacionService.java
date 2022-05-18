package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Aplicacion;
import ues.edu.sv.boltra.api.repository.AplicacionRepository;

@Service
public class AplicacionService extends AbsService<Aplicacion, AplicacionRepository> {

	@Autowired
	private AplicacionRepository repository;
	
	@Override
	protected AplicacionRepository getRepo() {
		return repository;
	}
	
}
