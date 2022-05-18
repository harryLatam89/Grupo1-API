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
@Table(name = "VACANTES")
public class Vacantes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VACANTE")
	private Long idVacante;
	@ManyToOne
	@JoinColumn(name = "ID_CONTRATANTE")
	private Contratante contratante;
	@Column(name = "NOMBRE_VACANTE")
	private String nombreVacante;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "ESTADO")
	private Integer estado;
	@Column(name = "ACTIVO")
	private Boolean activo;

	public Vacantes() {
	}

	public Vacantes(Long idVacante, Contratante contratante, String nombreVacante, String descripcion, Integer estado,
			Boolean activo) {
		this.idVacante = idVacante;
		this.contratante = contratante;
		this.nombreVacante = nombreVacante;
		this.descripcion = descripcion;
		this.estado = estado;
		this.activo = activo;
	}

	public Long getIdVacante() {
		return idVacante;
	}

	public void setIdVacante(Long idVacante) {
		this.idVacante = idVacante;
	}

	public Contratante getContratante() {
		return contratante;
	}

	public void setContratante(Contratante contratante) {
		this.contratante = contratante;
	}

	public String getNombreVacante() {
		return nombreVacante;
	}

	public void setNombreVacante(String nombreVacante) {
		this.nombreVacante = nombreVacante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Vacantes [idVacante=" + idVacante + ", contratante=" + contratante + ", nombreVacante=" + nombreVacante
				+ ", descripcion=" + descripcion + ", estado=" + estado + ", activo=" + activo + "]";
	}

}
