## Dockerfile from /resources/docker

FROM thiagolocatelli/ubuntu-corretto11:alpine-3.8-glibc2.27
#FROM adoptopenjdk/openjdk11:alpine-jre
#FROM adoptopenjdk/openjdk8:alpine-jre

ARG JAR_FILE
COPY target/${JAR_FILE} application.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "application.jar"]
