package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.Candidato;
import ues.edu.sv.boltra.api.models.CompetenciaCandidato;

@Repository public interface CompetenciaCandidatoRepository extends JpaRepository<CompetenciaCandidato, Long> {
	
	List<CompetenciaCandidato> findByCandidato(Candidato candidato);

}
