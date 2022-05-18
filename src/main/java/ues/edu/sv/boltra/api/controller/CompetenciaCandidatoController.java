package ues.edu.sv.boltra.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ues.edu.sv.boltra.api.models.CompetenciaCandidato;
import ues.edu.sv.boltra.api.repository.CompetenciaCandidatoRepository;
import ues.edu.sv.boltra.api.service.CompetenciaCandidatoService;

@RestController
@RequestMapping(path = "/competenciacandidato")
public class CompetenciaCandidatoController extends AbsController<CompetenciaCandidato, CompetenciaCandidatoRepository, CompetenciaCandidatoService>
		implements AbsInterface<CompetenciaCandidato> {

	@Autowired
	private CompetenciaCandidatoService service;

	@Override
	protected CompetenciaCandidatoService getServis() {
		return this.service;
	}

	@Override
	protected CompetenciaCandidato setId(CompetenciaCandidato entida, Long id) {
		entida.setIdCompetencia(id);
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
	public ResponseEntity<?> crearEntidad(@RequestBody CompetenciaCandidato entida, BindingResult result) {
		return crearEntida(entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<?> actualizarEntidad(@PathVariable(name = "id") Long id, @RequestBody CompetenciaCandidato entida,
			BindingResult result) {
		return actualizarEntida(id, entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void eliminarEntidad(@PathVariable(name = "id") Long id) {
		eliminarEntida(id);
	}
}
