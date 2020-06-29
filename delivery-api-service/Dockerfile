FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/delivery-api-service.jar
ADD ${JAR_FILE} delivery-api-service.jar
ENTRYPOINT ["java","-jar","/delivery-api-service.jar"]