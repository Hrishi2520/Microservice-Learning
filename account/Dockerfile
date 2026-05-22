# base image
FROM eclipse-temurin:17-alpine

WORKDIR /app

# add jar to container
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

EXPOSE 8080
# excecute the application
ENTRYPOINT ["java", "-jar", "account-0.0.1-SNAPSHOT.jar"]