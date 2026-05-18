#
# Build stage
#
FROM gradle:8.7-jdk21 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN chmod +x gradlew

RUN ./gradlew build --no-daemon

LABEL org.name="Mohammad Cheikh Mahmoud"

#
# Package stage
#
FROM eclipse-temurin:21-jdk-jammy

COPY --from=build /home/gradle/src/build/libs/Supplement-Tracker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
