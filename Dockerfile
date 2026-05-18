#
# Build stage
#
FROM gradle:9-jdk25 AS build

# Kopiert das gesamte Projekt in den Container
COPY --chown=gradle:gradle . /home/gradle/src

# Arbeitsverzeichnis setzen
WORKDIR /home/gradle/src

# Gradle Build ausführen
RUN gradle build --no-daemon

# Projektinformationen
LABEL org.name="Mohammad Cheikh Mahmoud"

#
# Package stage
#
FROM eclipse-temurin:25-jdk-jammy

# Kopiert die fertige .jar Datei aus dem Build-Container
COPY --from=build /home/gradle/src/build/libs/Supplement-Tracker-0.0.1-SNAPSHOT.jar app.jar

# Startet die Spring Boot Anwendung
ENTRYPOINT ["java","-jar","/app.jar"]
