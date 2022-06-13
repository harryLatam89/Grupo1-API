package ues.edu.sv.boltra.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.CompetenciaVacante;
import ues.edu.sv.boltra.api.models.Vacantes;

@Repository
public interface CompetenciaVacanteRepository extends JpaRepository<CompetenciaVacante, Long> {
	List<CompetenciaVacante> findByVacante(Vacantes vacante);
}
