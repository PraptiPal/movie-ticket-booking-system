FROM openjdk:17-alpine
ARG JAR_FILE=target/payment-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} paymentservice.jar
ENTRYPOINT ["java","-jar","/paymentservice.jar"]


