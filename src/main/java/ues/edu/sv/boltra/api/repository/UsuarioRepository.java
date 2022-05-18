package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.Usuario;

@Repository public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM USUARIO WHERE USER_NAME = ?1 AND USER_PASS = ?2 ")
	Usuario buscarUsuarioUsuarioYContrasenia(String usuarioName, String usuarioPass);

	@Query(nativeQuery = false, value = "SELECT US FROM Usuario US WHERE US.userName = ?1 AND US.userPass = ?2 ")
	Usuario buscarUsuarioUsuarioYContraseniaDos(String userName, String userPass);

	List<Usuario> findByUserNameAndUserPass(String userName, String userPass);

}
