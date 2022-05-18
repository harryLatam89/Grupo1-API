package ues.edu.sv.boltra.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ues.edu.sv.boltra.api.models.Usuario;
import ues.edu.sv.boltra.api.repository.UsuarioRepository;

@Service
public class UsuarioService extends AbsService<Usuario, UsuarioRepository> {

	@Autowired
	private UsuarioRepository repository;

	@Override
	protected UsuarioRepository getRepo() {
		return repository;
	}

	public Usuario iniciarSesion(Usuario user) {
		return getRepo().buscarUsuarioUsuarioYContrasenia(user.getUserName(), user.getUserPass());
	}

}
