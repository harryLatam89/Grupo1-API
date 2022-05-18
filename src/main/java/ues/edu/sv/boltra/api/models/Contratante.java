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
@Table(name = "CONTRATANTE")
public class Contratante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTRATANTE")
	private Long idContratante;
	@ManyToOne
	@JoinColumn(name = "ID_USARIO")
	private Usuario usuario;
	@Column(name = "AREA_ASIGNADA")
	private String areaAsignada;

	public Contratante() {
	}

	public Contratante(Long idContratante, Usuario usuario, String areaAsignada) {
		this.idContratante = idContratante;
		this.usuario = usuario;
		this.areaAsignada = areaAsignada;
	}

	public Long getIdContratante() {
		return idContratante;
	}

	public void setIdContratante(Long idContratante) {
		this.idContratante = idContratante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getAreaAsignada() {
		return areaAsignada;
	}

	public void setAreaAsignada(String areaAsignada) {
		this.areaAsignada = areaAsignada;
	}

	@Override
	public String toString() {
		return "Contratante [idContratante=" + idContratante + ", usuario=" + usuario + ", areaAsignada=" + areaAsignada
				+ "]";
	}

}
