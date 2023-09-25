FROM openjdk:17
ARG CONTAINER_NAME=ecomapp
ARG IMAGE_NAME=ecomapp
EXPOSE 8084
ADD target/EcommereceApp-rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

