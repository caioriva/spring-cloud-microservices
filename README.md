# spring-cloud-microservices
By Caio Riva

This is an example project for Testing Spring Cloud Netflix framework and microservices architecture. The application designed is intended to be a prototype for chat applications domain. This project uses **Spring Boot** (Spring Web (MVC), Spring Data MongoDB), **Spring Cloud** for service discovery, config server and gateway; and **MongoDB** as the base technologies and was developed with **Java 8**. It's also uses **Docker** and **Docker Compose**, so if you want to run the apllication be sure to install both.

## Endpoints example:

###### POST: http://localhost:8080/access/users
{
  "name": "",
  "password": ""
}

###### POST: http://localhost:8080/communication/rooms
{
  "name": "",
  "ownerUserId": "",
  "guestUsersId": \["", ""]\
}

###### POST: http://localhost:8080/communication/messages
{
  "text": "",
  "senderParticipantId": ""
}
