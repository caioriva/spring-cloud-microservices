FROM openjdk:8-jdk-alpine
MAINTAINER Caio Augusto Riva
VOLUME /tmp
COPY target/communication-service-0.0.1-SNAPSHOT.jar /opt/communication-service.jar
COPY start-communication-service.sh /opt/start-communication-service.sh
RUN chmod u=rwx,g=rx,o=rx /opt/start-communication-service.sh
EXPOSE 8084
