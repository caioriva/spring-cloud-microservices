#!/bin/sh

while ! nc -z configuration-service 8081 ; do

    echo "discovery-service is waiting for the configuration-service"

    sleep 3

done

sleep 10

java -jar -Dspring.profiles.active=production /opt/discovery-service.jar
