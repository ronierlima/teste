FROM maven:3-amazoncorretto-17 AS build

COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-slim
COPY --from=build /target/buildfit-0.0.1-SNAPSHOT.jar buildfit.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","buildfit.jar"]