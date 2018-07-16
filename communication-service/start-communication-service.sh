#!/bin/sh

while ! nc -z discovery-service 8082 ; do

    echo "communication-service is waiting for the discovery-service"

    sleep 3

done

java -jar /opt/communication-service.jar
