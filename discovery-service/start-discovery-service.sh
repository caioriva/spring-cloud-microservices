#!/bin/sh

while ! nc -z configuration-service 8081 ; do

    echo "discovery-service is waiting for the configurantion-service"

    sleep 3

done

sleep 10

java -jar /opt/discovery-service.jar
