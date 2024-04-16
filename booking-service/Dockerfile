FROM openjdk:17-alpine
ARG JAR_FILE=target/booking-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} bookingservice.jar
ENTRYPOINT exec java -jar bookingservice.jar
