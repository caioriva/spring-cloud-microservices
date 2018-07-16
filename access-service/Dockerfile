FROM openjdk:8-jdk-alpine
MAINTAINER Caio Augusto Riva
VOLUME /tmp
COPY target/access-service-0.0.1-SNAPSHOT.jar /opt/access-service.jar
COPY start-access-service.sh /opt/start-access-service.sh
RUN chmod u=rwx,g=rx,o=rx /opt/start-access-service.sh
EXPOSE 8085
