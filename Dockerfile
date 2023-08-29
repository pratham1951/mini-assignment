FROM tomcat:latest
COPY target/calculator.war /usr/local/tomcat/webapps/
