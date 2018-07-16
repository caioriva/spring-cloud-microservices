FROM openjdk:8-jdk-alpine
MAINTAINER Caio Augusto Riva
VOLUME /tmp
COPY target/discovery-service-0.0.1-SNAPSHOT.jar /opt/discovery-service.jar
COPY start-discovery-service.sh /opt/start-discovery-service.sh
RUN chmod u=rwx,g=rx,o=rx /opt/start-discovery-service.sh
EXPOSE 8082
