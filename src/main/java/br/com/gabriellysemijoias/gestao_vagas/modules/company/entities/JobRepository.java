package br.com.gabriellysemijoias.gestao_vagas.modules.company.entities;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, UUID>{

}
