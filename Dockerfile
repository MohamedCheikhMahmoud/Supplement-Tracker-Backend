#
# Build stage
#
FROM gradle:9-jdk25 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

# Gradle Wrapper ausführbar machen
RUN chmod +x gradlew

# Projekt bauen
RUN ./gradlew build --no-daemon

LABEL org.name="Mohammad Cheikh Mahmoud"

#
# Package stage
#
FROM eclipse-temurin:25-jdk-jammy

COPY --from=build /home/gradle/src/build/libs/Supplement-Tracker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
