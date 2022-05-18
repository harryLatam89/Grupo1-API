package ues.edu.sv.boltra.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.boltra.api.models.Aplicacion;

@Repository public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {

}
