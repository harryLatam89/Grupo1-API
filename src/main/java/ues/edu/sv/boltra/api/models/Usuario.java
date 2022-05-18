package ues.edu.sv.boltra.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USARIO")
	private Long idUsario;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_PASS")
	private String userPass;
	@Column(name = "CODIGO_DOCUMENTO")
	private String codigoDocumento;
	@Column(name = "TIPO_DOCUMENTO")
	private String tipoDocumento;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION")
	private Date fechaCreacion;
	@Column(name = "ACTIVO")
	private Boolean activo;

	public Usuario() {
	}

	public Usuario(Long idUsario, String nombre, String apellido, String userName, String userPass,
			String codigoDocumento, String tipoDocumento, Date fechaCreacion, Boolean activo) {
		this.idUsario = idUsario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.userName = userName;
		this.userPass = userPass;
		this.codigoDocumento = codigoDocumento;
		this.tipoDocumento = tipoDocumento;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}

	public Long getIdUsario() {
		return idUsario;
	}

	public void setIdUsario(Long idUsario) {
		this.idUsario = idUsario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsario=" + idUsario + ", nombre=" + nombre + ", apellido=" + apellido + ", userName="
				+ userName + ", userPass=" + userPass + ", codigoDocumento=" + codigoDocumento + ", tipoDocumento="
				+ tipoDocumento + ", fechaCreacion=" + fechaCreacion + ", activo=" + activo + "]";
	}

}
