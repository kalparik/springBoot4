FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY target/Rest2-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]