# Imagen base de OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy AS build

# Directorio de trabajo dentro del contenedor
WORKDIR /app

RUN apt-get update && apt-get install -y maven

# Copia el archivo pom.xml y descarga las dependencias de Maven
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Compila el proyecto Spring Boot en un archivo JAR ejecutable
RUN mvn clean install -DskipTests

# Imagen final ligera
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copia el JAR ejecutable desde la etapa de construcción
COPY --from=build /app/target/abastecimiento-api-proxy-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto de ejecución
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]