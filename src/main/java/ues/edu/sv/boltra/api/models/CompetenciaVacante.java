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
@Table(name = "COMPETENCIA_VACANTE")
public class CompetenciaVacante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPETENCIAV")
	private Long idCompetencia;
	@ManyToOne
	@JoinColumn(name = "ID_VACANTE")
	private Vacantes vacante;
	@ManyToOne
	@JoinColumn(name = "ID_COMPETENCIA")
	private Competencias competencia;

	public CompetenciaVacante() {
	}

	public CompetenciaVacante(Long idCompetencia, Vacantes vacante, Competencias competencia) {
		this.idCompetencia = idCompetencia;
		this.vacante = vacante;
		this.competencia = competencia;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Vacantes getVacante() {
		return vacante;
	}

	public void setVacante(Vacantes vacante) {
		this.vacante = vacante;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
	}

	@Override
	public String toString() {
		return "CompetenciaVacante [idCompetencia=" + idCompetencia + ", vacante=" + vacante + ", competencia="
				+ competencia + "]";
	}

}
