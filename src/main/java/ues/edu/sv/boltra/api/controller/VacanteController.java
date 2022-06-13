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

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.models.Vacantes;
import ues.edu.sv.boltra.api.repository.VacanteRepository;
import ues.edu.sv.boltra.api.service.VacanteService;

@RestController
@RequestMapping(path = "/vacante")
public class VacanteController extends AbsController<Vacantes, VacanteRepository, VacanteService>
		implements AbsInterface<Vacantes> {

	@Autowired
	private VacanteService service;

	@Override
	protected VacanteService getServis() {
		return this.service;
	}

	@Override
	protected Vacantes setId(Vacantes entida, Long id) {
		entida.setIdVacante(id);
		return entida;
	}

	@RequestMapping(path = "/contratante", method = RequestMethod.POST)
	public ResponseEntity<?> listaVacantesPorContratante(@RequestBody Contratante contratante, BindingResult result) {
		return new ResponseEntity<List<Vacantes>>(getServis().listarPorContratante(contratante), HttpStatus.OK);
	}

	@RequestMapping(path = "/candidato", method = RequestMethod.POST)
	public ResponseEntity<?> listaVacantesPorCandidato(@RequestBody Candidato candidato, BindingResult result) {
		return new ResponseEntity<List<Vacantes>>(getServis().listarPorCandidato(candidato), HttpStatus.OK);
	}

	@RequestMapping(path = "/contratante/desactivado", method = RequestMethod.POST)
	public ResponseEntity<?> listaVacantesPorContratanteActivos(@RequestBody Contratante contratante,
			BindingResult result) {
		return new ResponseEntity<List<Vacantes>>(getServis().listarPorInactivosContratante(contratante),
				HttpStatus.OK);
	}

	@RequestMapping(path = "/contratante/ocupado", method = RequestMethod.POST)
	public ResponseEntity<?> listaVacantesPorActivos(@RequestBody Contratante contratante, BindingResult result) {
		return new ResponseEntity<List<Vacantes>>(getServis().listarPorOcupadosContratante(contratante), HttpStatus.OK);
	}

	@RequestMapping(path = "/lista", method = RequestMethod.GET)
	@Override
	public ResponseEntity<?> listarEntidad() {
		return new ResponseEntity<List<Vacantes>>(getServis().listarActivos(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@Override
	public ResponseEntity<?> listarEntidadPorId(@PathVariable(name = "id") Long id) {
		return listarEntidaPorId(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public ResponseEntity<?> crearEntidad(@RequestBody Vacantes entida, BindingResult result) {
		return crearEntida(entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	@Override
	public ResponseEntity<?> actualizarEntidad(@PathVariable(name = "id") Long id, @RequestBody Vacantes entida,
			BindingResult result) {
		return actualizarEntida(id, entida, result);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@Override
	public void eliminarEntidad(@PathVariable(name = "id") Long id) {
		eliminarEntida(id);
	}
}
