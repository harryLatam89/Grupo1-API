package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.AreaLaboral;
import ues.edu.sv.boltra.api.repository.AreaLaboralRepository;

@Service
public class AreaLaboralService extends AbsService<AreaLaboral, AreaLaboralRepository> {

	@Autowired
	private AreaLaboralRepository repository;
	
	@Override
	protected AreaLaboralRepository getRepo() {
		return repository;
	}
	
}
