#!/bin/sh

while ! nc -z discovery-service 8082 ; do

    echo "access-service is waiting for the discovery-service"

    sleep 3

done

java -jar -Dspring.profiles.active=production /opt/access-service.jar
