FROM ubuntu:latest as build 
WORKDIR /app
COPY . .
RUN apt update && apt install openjdk-17-jdk-headless -y  && apt install maven -y
# RUN yum update && yum install maven -y
RUN mvn install
FROM tomcat:latest
COPY --from=build /app/target/calculator.war /usr/local/tomcat/webapps/
EXPOSE 8080