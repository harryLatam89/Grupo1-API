package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.models.Usuario;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, Long> {

	List<Contratante> findByUsuario(Usuario usuario);

}
