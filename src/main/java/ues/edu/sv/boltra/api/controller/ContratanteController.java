package ues.edu.sv.boltra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.repository.ContratanteRepository;
import ues.edu.sv.boltra.api.service.ContratanteService;

@RestController
@RequestMapping(path = "/contratante")
public class ContratanteController extends AbsController<Contratante, ContratanteRepository, ContratanteService>
		implements AbsInterface<Contratante> {

	@Autowired
	private ContratanteService service;

	@Override
	protected ContratanteService getServis() {
		return this.service;
	}

	@Override
	protected Contratante setId(Contratante entida, Long id) {
		entida.setIdContratante(id);
		return entida;
	}

	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	@Override
	public ResponseEntity<?> listarEntidad() {
		return listarEntida();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Override
	public ResponseEntity<?> listarEntidadPorId(@PathVariable(name = "id") Long id) {
		return listarEntidaPorId(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public ResponseEntity<?> crearEntidad(@RequestBody Contratante entida, BindingResult result) {
		return crearEntida(entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<?> actualizarEntidad(@PathVariable(name = "id") Long id, @RequestBody Contratante entida,
			BindingResult result) {
		return actualizarEntida(id, entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void eliminarEntidad(@PathVariable(name = "id") Long id) {
		eliminarEntida(id);
	}
}
