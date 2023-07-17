FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . . 

FROM openjdk:17-jdk-slim
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/emailscheduler-v1.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]