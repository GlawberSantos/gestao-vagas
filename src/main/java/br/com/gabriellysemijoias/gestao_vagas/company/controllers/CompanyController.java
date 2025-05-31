package br.com.gabriellysemijoias.gestao_vagas.company.controllers;

import br.com.gabriellysemijoias.gestao_vagas.company.dto.AuthCompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody AuthCompanyDTO dto) {
        System.out.println("Criando empresa: " + dto.getUsername());
        return ResponseEntity.ok("Empresa criada com sucesso!");
    }
}
