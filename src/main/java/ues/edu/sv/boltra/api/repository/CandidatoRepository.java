package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.Usuario;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

	List<Candidato> findByUsuario(Usuario usuario);

}
