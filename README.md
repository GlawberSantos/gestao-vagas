# Gestão de Vagas

API REST para gestão de vagas de emprego, com dois perfis de usuário — **empresa** (publica vagas) e **candidato** (se inscreve) — autenticação própria para cada perfil via JWT, e stack de observabilidade com Prometheus e Grafana.

## ✨ Funcionalidades

- Cadastro e autenticação de empresas (JWT próprio)
- Cadastro e autenticação de candidatos (JWT próprio)
- Empresas podem criar e listar vagas
- Candidatos podem listar vagas (com filtro) e se candidatar
- Perfil do candidato mostra as vagas em que já se candidatou
- Documentação interativa via Swagger/OpenAPI
- Métricas expostas para Prometheus, com dashboard pronto no Grafana

## 🧱 Arquitetura

O projeto segue uma separação por módulo de domínio, cada um com seu próprio fluxo de autenticação:

```
modules/
├── candidate/       # Cadastro, autenticação, perfil e candidatura a vagas
└── company/         # Cadastro, autenticação, criação e listagem de vagas
providers/           # Geração e validação de JWT (um provider por perfil)
security/            # Filtros de segurança e configuração central (SecurityConfig)
exceptions/          # Exceptions de domínio e handler global
```

Cada perfil (empresa/candidato) tem seu próprio segredo de JWT e seu próprio filtro de segurança, então um token de candidato não autentica rotas de empresa e vice-versa.

## 🚀 Tecnologias

- **Java 17** + **Spring Boot 3.5**
- Spring Web, Spring Data JPA, Spring Security
- **PostgreSQL**
- **JWT** (java-jwt / Auth0)
- **Springdoc OpenAPI** (Swagger UI)
- **Docker** + **Docker Compose**
- **Prometheus** + **Grafana** (observabilidade)
- **JUnit / Spring Boot Test** + **H2** (testes)
- **JaCoCo** (cobertura de testes) + **SonarQube** (análise estática)

## ▶️ Como rodar localmente

### Pré-requisitos
- Docker e Docker Compose instalados

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/GlawberSantos/gestao-vagas.git
   cd gestao-vagas
   ```

2. Copie o arquivo de variáveis de ambiente e preencha os segredos:
   ```bash
   cp .env.example .env
   ```
   Gere segredos únicos para `JWT_SECRET_COMPANY` e `JWT_SECRET_CANDIDATE`, por exemplo:
   ```bash
   openssl rand -base64 32
   ```

3. Suba os containers:
   ```bash
   docker-compose up -d
   ```

4. A API estará disponível em `http://localhost:8080`.

### Rodando sem Docker

Com um PostgreSQL local rodando, exporte as variáveis de ambiente (`DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`, `JWT_SECRET_COMPANY`, `JWT_SECRET_CANDIDATE`) e rode:

```bash
./mvnw spring-boot:run
```

## 📖 Documentação da API

Com a aplicação rodando, acesse o Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

## 📊 Observabilidade

O `docker-compose.yml` já sobe Prometheus (`localhost:9090`) e Grafana (`localhost:3000`), consumindo as métricas expostas pelo Actuator em `/actuator/prometheus`.

## 🧪 Testes

```bash
./mvnw test
```

A cobertura de testes é gerada via JaCoCo a cada build.

## 🔐 Segurança

- Segredos JWT e credenciais de banco são lidos exclusivamente de variáveis de ambiente — nenhum segredo fica hardcoded no código ou nos arquivos de configuração versionados.
- Senhas de usuário são armazenadas com hash BCrypt.
- O arquivo `.env` está no `.gitignore` e nunca deve ser commitado.

## 📄 Licença

Este projeto está sob a licença MIT.
