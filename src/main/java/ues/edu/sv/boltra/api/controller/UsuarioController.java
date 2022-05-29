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

import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.repository.UsuarioRepository;
import ues.edu.sv.boltra.api.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController extends AbsController<Usuario, UsuarioRepository, UsuarioService>
		implements AbsInterface<Usuario> {

	@Autowired
	private UsuarioService service;

	@Override
	protected UsuarioService getServis() {
		return this.service;
	}

	@Override
	protected Usuario setId(Usuario entida, Long id) {
		entida.setIdUsario(id);
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
	public ResponseEntity<?> crearEntidad(@RequestBody Usuario entida, BindingResult result) {
		return crearEntida(entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<?> actualizarEntidad(@PathVariable(name = "id") Long id, @RequestBody Usuario entida,
			BindingResult result) {
		return actualizarEntida(id, entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void eliminarEntidad(@PathVariable(name = "id") Long id) {
		eliminarEntida(id);
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Usuario entida) {
		Usuario user = getServis().iniciarSesion(entida);
		if (user == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("codigo", 1001);
			response.put("mensaje", "objeto no encontrado.");
			response.put("descripcion", "El Usuario no se encontró en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
}
