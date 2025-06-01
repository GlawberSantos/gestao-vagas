package br.com.gabriellysemijoias.gestao_vagas.modules.candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabriellysemijoias.gestao_vagas.modules.candidate.entity.ApplyJobEntity;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
    
}
