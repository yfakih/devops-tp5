FROM openjdk:17

COPY target/book-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8090