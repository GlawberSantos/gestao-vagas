package br.com.gabriellysemijoias.gestao_vagas.modules.company.repositories;

import br.com.gabriellysemijoias.gestao_vagas.modules.company.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
}
