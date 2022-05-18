package ues.edu.sv.boltra.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APLICACION")
public class Aplicacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_APLICACION")
	private Long idAplicacion;
	@ManyToOne
	@JoinColumn(name = "ID_CANDIDATO")
	private Candidato candidato;
	@ManyToOne
	@JoinColumn(name = "ID_VACANTE")
	private Vacantes vacante;

	public Aplicacion() {
	}

	public Aplicacion(Long idAplicacion, Candidato candidato, Vacantes vacante) {
		this.idAplicacion = idAplicacion;
		this.candidato = candidato;
		this.vacante = vacante;
	}

	public Long getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Vacantes getVacante() {
		return vacante;
	}

	public void setVacante(Vacantes vacante) {
		this.vacante = vacante;
	}

	@Override
	public String toString() {
		return "Aplicacion [idAplicacion=" + idAplicacion + ", candidato=" + candidato + ", vacante=" + vacante + "]";
	}

}
