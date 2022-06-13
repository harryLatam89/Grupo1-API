package ues.edu.sv.boltra.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ues.edu.sv.boltra.api.models.RolUsuario;
import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.repository.RolUsuarioRepository;
import ues.edu.sv.boltra.api.service.RolUsuarioService;

@RestController
@RequestMapping(path = "/rolusuario")
public class RolUsuarioController extends AbsController<RolUsuario, RolUsuarioRepository, RolUsuarioService>
		implements AbsInterface<RolUsuario> {

	@Autowired
	private RolUsuarioService service;

	@Override
	protected RolUsuarioService getServis() {
		return this.service;
	}

	@Override
	protected RolUsuario setId(RolUsuario entida, Long id) {
		entida.setIdRol(id);
		return entida;
	}

	@RequestMapping(path = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<?> buscarRolesDeUsuario(@RequestBody Usuario entida) {
		return new ResponseEntity<List<RolUsuario>>(getServis().obtenerRolesDeUsuario(entida), HttpStatus.OK);
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
	public ResponseEntity<?> crearEntidad(@RequestBody RolUsuario entida, BindingResult result) {
		return crearEntida(entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<?> actualizarEntidad(@PathVariable(name = "id") Long id, @RequestBody RolUsuario entida,
			BindingResult result) {
		return actualizarEntida(id, entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void eliminarEntidad(@PathVariable(name = "id") Long id) {
		eliminarEntida(id);
	}

}
