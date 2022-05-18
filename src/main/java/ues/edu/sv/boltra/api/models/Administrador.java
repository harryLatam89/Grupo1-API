package ues.edu.sv.boltra.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADMINISTRADOR")
	private Long idAdministrador;
	@ManyToOne
	@JoinColumn(name = "ID_USARIO")
	private Usuario usuario;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_EXPIRACION")
	private Date fechaExpiracion;

	public Administrador() {
	}

	public Administrador(Long idAdministrador, Usuario usuario, Date fechaExpiracion) {
		this.idAdministrador = idAdministrador;
		this.usuario = usuario;
		this.fechaExpiracion = fechaExpiracion;
	}

	public Long getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", usuario=" + usuario + ", fechaExpiracion="
				+ fechaExpiracion + "]";
	}

}
