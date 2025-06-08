# Etapa de build
FROM eclipse-temurin:17-jdk-jammy AS build

# Atualiza e instala o Maven
RUN apt-get update && apt-get install -y maven

# Copia todos os arquivos do projeto para a imagem
COPY . .

# Compila o projeto, ignorando os testes
RUN mvn clean install -DskipTests

# Etapa final: usa uma imagem mais leve para rodar a aplicação
FROM eclipse-temurin:17-jdk-jammy

# Expõe a porta 8080
EXPOSE 8080

# Copia o JAR gerado para a imagem final
COPY --from=build target/gestao_vagas-0.0.1.jar app.jar

# Define o comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
