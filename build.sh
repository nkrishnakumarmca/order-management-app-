#!/bin/bash

mvn clean install -f shop-api-service/pom.xml
mvn clean install -f order-api-service/pom.xml
mvn clean install -f delivery-api-service/pom.xml

cd order-api-service/
docker build -t order-api-service .
cd ../shop-api-service/
docker build -t shop-api-service .
cd ../delivery-api-service/
docker build -t delivery-api-service .
docker-compose up