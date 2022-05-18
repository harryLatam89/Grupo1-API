package ues.edu.sv.boltra.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import ues.edu.sv.boltra.api.service.AbsService;

public abstract class AbsController<Entida, Repo extends JpaRepository<Entida, Long>, Servis extends AbsService<Entida, Repo>> {

	protected abstract Servis getServis();

	protected abstract Entida setId(Entida entida, Long id);

//	http://127.0.0.1:9090/entida
//	GET www.aplicacion.com/entida/lista --> listarEntidad();
//	GET www.aplicacion.com/entida/1 --> listarEntidaPorId(1);
//	POST www.aplicacion.com/entida/ --> crearEntida(body, result);
//	PUT www.aplicacion.com/entida/ --> actualizarEntida(body, result);
//	DELETE www.aplicacion.com/entida/1 --> actualizarEntida(body, result);
	
//	http://127.0.0.1:9090/aplicacion java api
//	http://127.0.0.1:3306/mysql servidor
//	http://127.0.0.1:1433/sql servidor de microsoft
//	http://127.0.0.1:8080/java tomcat
//	http://127.0.0.1:4200/ angular cli

	public ResponseEntity<?> listarEntida() {
		return new ResponseEntity<List<Entida>>(getServis().leerEntida(), HttpStatus.OK);
	}

	public ResponseEntity<?> listarEntidaPorId(Long id) {
		Entida entida = getServis().buscarEntidaPorId(id);
		if (entida == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("codigo", 1001);
			response.put("mensaje", "objeto no encontrada.");
			response.put("descripcion",
					"El Objeto con el id ".concat(id.toString()).concat(" no se encontró en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Entida>(entida, HttpStatus.OK);
	}

	public ResponseEntity<?> crearEntida(Entida entida, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, Object> response = new HashMap<>();
			List<HashMap<String, Object>> errors = new ArrayList<>();
			result.getFieldErrors().forEach(err -> {
				Map<String, Object> error = new HashMap<>();
				error.put("campo", err.getField());
				error.put("mensaje", err.getDefaultMessage());
				errors.add((HashMap<String, Object>) error);
			});

			response.put("codigo", 1000);
			response.put("mensaje", "Error de validacion.");
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Entida>(getServis().crearEntida(entida), HttpStatus.CREATED);
	}

	public ResponseEntity<?> actualizarEntida(Long id, Entida entida, BindingResult result) {
		if (result.hasErrors()) {
			Map<String, Object> response = new HashMap<>();
			List<HashMap<String, Object>> errors = new ArrayList<>();
			result.getFieldErrors().forEach(err -> {
				Map<String, Object> error = new HashMap<>();
				error.put("campo", err.getField());
				error.put("mensaje", err.getDefaultMessage());
				errors.add((HashMap<String, Object>) error);
			});

			response.put("codigo", 1000);
			response.put("mensaje", "Error de validacion.");
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (getServis().buscarEntidaPorId(id) == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("codigo", 1001);
			response.put("mensaje", "no encontrado.");
			response.put("descripcion",
					"El Objeto con el id ".concat(id.toString()).concat(" no se encontró en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		setId(entida, id);
		return new ResponseEntity<Entida>(getServis().actualizarEntida(entida), HttpStatus.ACCEPTED);
	}

	public void eliminarEntida(Long id) {
		getServis().borrarEntida(id);
	}

}
