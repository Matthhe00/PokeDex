# Utilisez l'image de base officielle OpenJDK
FROM openjdk:21-jdk-slim

# Définir un répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/pokefinder-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 50972

# Définir la commande pour démarrer l'application Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
