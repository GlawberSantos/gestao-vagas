package br.com.gabriellysemijoias.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriellysemijoias.gestao_vagas.modules.company.entities.JobEntity;
import br.com.gabriellysemijoias.gestao_vagas.modules.company.entities.JobRepository;

@Service
public class CreateJobUseCase {

  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    // Aqui você pode colocar regras de negócio antes de salvar, se necessário

    return jobRepository.save(jobEntity); // Salva no banco de dados
  }
}
