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
@Table(name = "CANDIDATO")
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CANDIDATO")
	private Long idCandidato;
	@ManyToOne
	@JoinColumn(name = "ID_USARIO")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "ID_AREA")
	private AreaLaboral areaLaboral;
	@Column(name = "LABORANDO")
	private Boolean laborando;

	public Candidato() {
	}

	public Candidato(Long idCandidato, Usuario usuario, AreaLaboral areaLaboral, Boolean laborando) {
		this.idCandidato = idCandidato;
		this.usuario = usuario;
		this.areaLaboral = areaLaboral;
		this.laborando = laborando;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AreaLaboral getAreaLaboral() {
		return areaLaboral;
	}

	public void setAreaLaboral(AreaLaboral areaLaboral) {
		this.areaLaboral = areaLaboral;
	}

	public Boolean getLaborando() {
		return laborando;
	}

	public void setLaborando(Boolean laborando) {
		this.laborando = laborando;
	}

	@Override
	public String toString() {
		return "Candidato [idCandidato=" + idCandidato + ", usuario=" + usuario + ", areaLaboral=" + areaLaboral
				+ ", laborando=" + laborando + "]";
	}

}
