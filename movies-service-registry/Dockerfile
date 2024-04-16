FROM openjdk:17-alpine
ARG JAR_FILE=target/movies-service-registry-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} movieregistry.jar
ENTRYPOINT exec java -jar movieregistry.jar
