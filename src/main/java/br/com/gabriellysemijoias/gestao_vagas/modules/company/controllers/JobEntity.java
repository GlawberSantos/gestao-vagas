package br.com.gabriellysemijoias.gestao_vagas.modules.company.controllers;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera getters/setters
@Builder // Gera o builder corretamente
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobEntity {

    @Id
    private UUID id;

    private UUID companyId;

    private String description;

    private String level;

    private List<String> benefits;
}
