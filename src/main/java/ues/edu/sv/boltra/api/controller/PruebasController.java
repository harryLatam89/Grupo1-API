package ues.edu.sv.boltra.api.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ues.edu.sv.boltra.api.models.AreaLaboral;
import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.CompetenciaCandidato;
import ues.edu.sv.boltra.api.models.CompetenciaVacante;
import ues.edu.sv.boltra.api.models.Competencias;
import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.models.Rol;
import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.models.Vacantes;
import ues.edu.sv.boltra.api.service.AreaLaboralService;
import ues.edu.sv.boltra.api.service.CandidatoService;
import ues.edu.sv.boltra.api.service.CompetenciaCandidatoService;
import ues.edu.sv.boltra.api.service.CompetenciaService;
import ues.edu.sv.boltra.api.service.CompetenciaVacanteService;
import ues.edu.sv.boltra.api.service.ContratanteService;
import ues.edu.sv.boltra.api.service.RolService;
import ues.edu.sv.boltra.api.service.UsuarioService;
import ues.edu.sv.boltra.api.service.VacanteService;

@RestController
@RequestMapping(path = "/prueba")
public class PruebasController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AreaLaboralService areaLaboralService;

	@Autowired
	private CandidatoService candidatoService;

	@Autowired
	private CompetenciaService competenciaService;

	@Autowired
	private ContratanteService contratanteService;

	@Autowired
	private VacanteService vacanteService;

	@Autowired
	private CompetenciaVacanteService competenciaVacanteService;

	@Autowired
	private CompetenciaCandidatoService competenciaCandidatoService;

	@Autowired
	private RolService rolService;

	@RequestMapping(path = "/prueba", method = RequestMethod.GET)
	public ResponseEntity<?> datosPrueba() {
		Usuario user = new Usuario(1L, "pruebas", "pruebas", "pruebas", "1234567", "DUI", "05050505-6", new Date(),
				"pruebas@pruebas.com", "7777-7777", true);
		Usuario userDos = new Usuario(2L, "pruebas Dos", "pruebas Dos", "pruebaDos", "1234567", "DUI", "05050505-6",
				new Date(), "pruebasDos@pruebas.com", "7777-7777", true);
		usuarioService.crearEntida(user);
		usuarioService.crearEntida(userDos);
		AreaLaboral areaLaboral = new AreaLaboral(1L, "area de prueba");
		AreaLaboral areaLaboralDos = new AreaLaboral(2L, "area de prueba dos");
		AreaLaboral areaLaboralTres = new AreaLaboral(3L, "area de prueba tres");
		areaLaboralService.crearEntida(areaLaboral);
		areaLaboralService.crearEntida(areaLaboralDos);
		areaLaboralService.crearEntida(areaLaboralTres);
		Candidato candidato = new Candidato(1L, user, areaLaboralDos, false);
		Candidato candidatoDos = new Candidato(2L, user, areaLaboralDos, false);
		candidatoService.crearEntida(candidato);
		candidatoService.crearEntida(candidatoDos);
		Competencias competencias = new Competencias(1L, areaLaboral, "competencia de prueba");
		competenciaService.crearEntida(competencias);
		Contratante contratante = new Contratante(1L, userDos, areaLaboralDos.getNombreArea());
		contratanteService.crearEntida(contratante);
		Contratante contratanteDos = new Contratante(2L, user, areaLaboral.getNombreArea());
		contratanteService.crearEntida(contratanteDos);
		Vacantes vacantes = new Vacantes(1L, contratante, "vacante de prueba", "es un dato de prueba", 1, true);
		vacanteService.crearEntida(vacantes);
		Vacantes vacantesDos = new Vacantes(2L, contratanteDos, "vacante de prueba", "es un dato de prueba", 1, true);
		vacanteService.crearEntida(vacantesDos);
		CompetenciaVacante competenciaVacante = new CompetenciaVacante(1L, vacantes, competencias);
		competenciaVacanteService.crearEntida(competenciaVacante);
		CompetenciaVacante competenciaVacanteDos = new CompetenciaVacante(2L, vacantesDos, competencias);
		competenciaVacanteService.crearEntida(competenciaVacanteDos);
		CompetenciaCandidato competenciaCandidato = new CompetenciaCandidato(1L, candidato, competencias);
		competenciaCandidatoService.crearEntida(competenciaCandidato);

		Rol rolUno = new Rol(1L, "Administrador");
		Rol rolDos = new Rol(2L, "Contratante");
		Rol rolTres = new Rol(3L, "Candidato");
		rolService.crearEntida(rolUno);
		rolService.crearEntida(rolDos);
		rolService.crearEntida(rolTres);

		return new ResponseEntity<String>("OKAY", HttpStatus.OK);
	}
}
