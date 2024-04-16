FROM openjdk:17-alpine
ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} apigateway.jar
ENTRYPOINT ["java","-jar","/apigateway.jar"]