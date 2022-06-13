package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.RolUsuario;
import ues.edu.sv.boltra.api.models.Usuario;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {

	List<RolUsuario> findByUsuario(Usuario usuario);

}
