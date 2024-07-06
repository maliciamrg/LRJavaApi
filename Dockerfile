FROM openjdk:17-jdk-alpine
EXPOSE 8080/tcp
COPY target/LRJavaApi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
