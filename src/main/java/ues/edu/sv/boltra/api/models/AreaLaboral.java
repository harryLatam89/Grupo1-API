package ues.edu.sv.boltra.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AREA_LABORAL")
public class AreaLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AREA")
	private Long idArea;
	@Column(name = "NOMBRE_AREA")
	private String nombreArea;

	public AreaLaboral() {
	}

	public AreaLaboral(Long idArea, String nombreArea) {
		this.idArea = idArea;
		this.nombreArea = nombreArea;
	}

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	@Override
	public String toString() {
		return "AreaLaboral [idArea=" + idArea + ", nombreArea=" + nombreArea + "]";
	}

}
