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
@Table(name = "ROL")
public class RolUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private Long idRol;

	@ManyToOne
	@JoinColumn(name = "ID_USARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "ID_ROL")
	private Rol rol;

	public RolUsuario() {
	}

	public RolUsuario(Long idRol, Usuario usuario, Rol rol) {
		this.idRol = idRol;
		this.usuario = usuario;
		this.rol = rol;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "RolUsuario [idRol=" + idRol + ", usuario=" + usuario + ", rol=" + rol + "]";
	}

}
