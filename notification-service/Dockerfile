FROM openjdk:17-alpine
ARG JAR_FILE=target/notification-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} notificationservice.jar
ENTRYPOINT exec java -jar notificationservice.jar
