FROM maven:3-amazoncorretto-17 AS build

COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar buildfit-api.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","buildfit.jar"]