FROM maven:3-amazoncorretto-17 AS build

COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-slim
COPY --from=build /target/buildfit-api-0.0.1-SNAPSHOT.jar buildfit-api.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","buildfit-api.jar"]