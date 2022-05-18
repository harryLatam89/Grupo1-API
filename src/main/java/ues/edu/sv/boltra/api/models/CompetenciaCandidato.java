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
@Table(name = "COMPETENCIA_CANDIDATO")
public class CompetenciaCandidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPETENCIAC")
	private Long IdCompetencia;
	@ManyToOne
	@JoinColumn(name = "ID_CANDIDATO")
	private Candidato candidato;
	@ManyToOne
	@JoinColumn(name = "ID_COMPETENCIA")
	private Competencias competencia;

	public CompetenciaCandidato() {
	}

	public CompetenciaCandidato(Long idCompetencia, Candidato candidato, Competencias competencia) {
		IdCompetencia = idCompetencia;
		this.candidato = candidato;
		this.competencia = competencia;
	}

	public Long getIdCompetencia() {
		return IdCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		IdCompetencia = idCompetencia;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
	}

	@Override
	public String toString() {
		return "CompetenciaCandidato [IdCompetencia=" + IdCompetencia + ", candidato=" + candidato + ", competencia="
				+ competencia + "]";
	}

}
