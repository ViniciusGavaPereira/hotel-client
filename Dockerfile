# Use uma imagem base do JDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY hotel-client.jar app.jar

# Copie o arquivo de configuração YAML para o contêiner
COPY src/main/java/docker_client/docker-compose.yml application.yml

# Exponha a porta que a aplicação irá rodar
EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
