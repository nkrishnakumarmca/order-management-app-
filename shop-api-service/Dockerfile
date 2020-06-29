FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/shop-api-service.jar
ADD ${JAR_FILE} shop-api-service.jar
ENTRYPOINT ["java","-jar","/shop-api-service.jar"]