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
@Table(name = "COMPETENCIAS")
public class Competencias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPETENCIA")
	private Long idCompetencia;
	@ManyToOne
	@JoinColumn(name = "NOMBRE_AREA")
	private AreaLaboral areaLaboral;
	@Column(name = "NOMBRE_COMPETENCIA")
	private String nombreCompetencia;

	public Competencias() {
	}

	public Competencias(Long idCompetencia, AreaLaboral areaLaboral, String nombreCompetencia) {
		this.idCompetencia = idCompetencia;
		this.areaLaboral = areaLaboral;
		this.nombreCompetencia = nombreCompetencia;
	}

	public Long getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public AreaLaboral getAreaLaboral() {
		return areaLaboral;
	}

	public void setAreaLaboral(AreaLaboral areaLaboral) {
		this.areaLaboral = areaLaboral;
	}

	public String getNombreCompetencia() {
		return nombreCompetencia;
	}

	public void setNombreCompetencia(String nombreCompetencia) {
		this.nombreCompetencia = nombreCompetencia;
	}

	@Override
	public String toString() {
		return "Competencias [idCompetencia=" + idCompetencia + ", areaLaboral=" + areaLaboral + ", nombreCompetencia="
				+ nombreCompetencia + "]";
	}

}
