FROM openjdk:8-jdk-alpine
MAINTAINER Caio Augusto Riva
VOLUME /tmp
COPY target/gateway-service-0.0.1-SNAPSHOT.jar /opt/gateway-service.jar
COPY start-gateway-service.sh /opt/start-gateway-service.sh
RUN chmod u=rwx,g=rx,o=rx /opt/start-gateway-service.sh
EXPOSE 8080
