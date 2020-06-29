FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/order-api-service.jar
ADD ${JAR_FILE} order-api-service.jar
ENTRYPOINT ["java","-jar","/order-api-service.jar"]