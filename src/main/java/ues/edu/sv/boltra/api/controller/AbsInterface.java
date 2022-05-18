package ues.edu.sv.boltra.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface AbsInterface<Entida> {

	public ResponseEntity<?> listarEntidad();

	public ResponseEntity<?> listarEntidadPorId(Long id);

	public ResponseEntity<?> crearEntidad(Entida entida, BindingResult result);

	public ResponseEntity<?> actualizarEntidad(Long id, Entida entida, BindingResult result);

	public void eliminarEntidad(Long id);

}
