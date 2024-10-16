# Etapa 1: Imagem base para build
FROM maven:3.9.9-eclipse-temurin-23 AS builder

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml ./
RUN mvn dependency:go-offline

# Comando para rodar a aplicação com hot reload
CMD ["mvn", "compile", "spring-boot:run"]