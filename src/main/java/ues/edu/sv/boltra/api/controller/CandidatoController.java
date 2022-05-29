package ues.edu.sv.boltra.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.repository.CandidatoRepository;
import ues.edu.sv.boltra.api.service.CandidatoService;

@RestController
@RequestMapping(path = "/candidato")
public class CandidatoController extends AbsController<Candidato, CandidatoRepository, CandidatoService>
		implements AbsInterface<Candidato> {

	@Autowired
	private CandidatoService service;

	@Override
	protected CandidatoService getServis() {
		return this.service;
	}

	@Override
	protected Candidato setId(Candidato entida, Long id) {
		entida.setIdCandidato(id);
		return entida;
	}

	@RequestMapping(path = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<?> buscarEntidadPorUsuario(@RequestBody Usuario entida, BindingResult result) {
		Candidato candidato = getServis().buscarPorUsuario(entida);
		if (candidato == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("codigo", 1001);
			response.put("mensaje", "objeto no encontrado.");
			response.put("descripcion", "El Objeto no se encontró en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Candidato>(candidato, HttpStatus.OK);
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
	public ResponseEntity<?> crearEntidad(@RequestBody Candidato entida, BindingResult result) {
		return crearEntida(entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<?> actualizarEntidad(@PathVariable(name = "id") Long id, @RequestBody Candidato entida,
			BindingResult result) {
		return actualizarEntida(id, entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void eliminarEntidad(@PathVariable(name = "id") Long id) {
		eliminarEntida(id);
	}
}
