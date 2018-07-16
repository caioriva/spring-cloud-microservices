#!/bin/sh

while ! nc -z communication-service 8084 ; do

    echo "gateway-service is waiting for the communication-service"

    sleep 3

done

while ! nc -z access-service 8085 ; do

    echo "gateway-service is waiting for the access-service"

    sleep 3

done

java -jar /opt/gateway-service.jar
