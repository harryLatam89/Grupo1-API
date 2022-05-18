package ues.edu.sv.boltra.api.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbsService<Entida, Repo extends JpaRepository<Entida, Long>> {

	protected abstract Repo getRepo();

	public Entida crearEntida(Entida entidaParametro) {
		return getRepo().save(entidaParametro);
	}

	public Entida actualizarEntida(Entida entidaParametro) {
		return getRepo().save(entidaParametro);
	}

	public List<Entida> leerEntida() {
		return getRepo().findAll();
	}

	public void borrarEntida(Long idEntidaParametro) {
		getRepo().deleteById(idEntidaParametro);
	}

	public Entida buscarEntidaPorId(Long idEntidaParametro) {
		return getRepo().findById(idEntidaParametro).orElse(null);
	}
}
