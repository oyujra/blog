# Usa una imagen base de OpenJDK
FROM openjdk:21-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo de compilación Gradle y el código fuente
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Ejecuta Gradle para compilar el proyecto
RUN ./gradlew build --no-daemon

# Copia el JAR generado al contenedor
COPY build/libs/*.jar app.jar

# Expone el puerto que usará tu aplicación
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
