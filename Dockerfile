FROM openjdk:17-jdk-alpine
EXPOSE 8080/tcp
COPY target/lrcatApi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]
