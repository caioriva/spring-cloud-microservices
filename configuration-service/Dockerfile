FROM openjdk:8-jdk-alpine
MAINTAINER Caio Augusto Riva
VOLUME /tmp
COPY target/configuration-service-0.0.1-SNAPSHOT.jar /opt/configuration-service.jar
ENTRYPOINT ["java", "-jar", "/opt/configuration-service.jar"]
EXPOSE 8081