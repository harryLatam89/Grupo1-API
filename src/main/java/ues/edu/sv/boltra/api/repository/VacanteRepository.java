package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.Contratante;
import ues.edu.sv.boltra.api.models.Vacantes;

@Repository
public interface VacanteRepository extends JpaRepository<Vacantes, Long> {

	List<Vacantes> findByContratanteAndActivo(Contratante contratante, Boolean activo);

	List<Vacantes> findByContratanteAndActivoAndEstado(Contratante contratante, Boolean activo, Integer estado);

	List<Vacantes> findByActivo(Boolean activo);

	@Query(nativeQuery = true, value = "SELECT VA.* FROM VACANTES VA "
			+ " INNER JOIN COMPETENCIA_VACANTE CV ON VA.ID_VACANTE = CV.ID_VACANTE"
			+ " INNER JOIN COMPETENCIA_CANDIDATO CC ON CV.ID_COMPETENCIA = CC.ID_COMPETENCIA "
			+ " INNER JOIN CANDIDATO CD ON CD.ID_CANDIDATO = CC.ID_CANDIDATO AND CD.ID_CANDIDATO = ?"
			+ " WHERE VA.ACTIVO = 1 ")
	List<Vacantes> findRecomendacionParaCandidato(Long idCandidato);
}
