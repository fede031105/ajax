# ==========================================
# Etapa 1: Compilación del proyecto (Build)
# ==========================================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia el archivo pom.xml para descargar las dependencias primero (aprovecha la caché de Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia el código fuente y compila el archivo .jar omitiendo las pruebas unitarias
COPY src ./src
RUN mvn clean package -DskipTests

# ==========================================
# Etapa 2: Imagen final de ejecución (Run)
# ==========================================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia el archivo .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto por defecto (Render asignará uno dinámicamente)
EXPOSE 8080

# Ejecuta la aplicación mapeando dinámicamente el puerto que Render nos proporcione
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT:8080}"]