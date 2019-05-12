## Dockerfile from /resources/docker

FROM adoptopenjdk/openjdk11-openj9:alpine-slim

ARG JAR_FILE
COPY target/${JAR_FILE} application.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "application.jar"]
