FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .

# go inside folder that has pom.xml
WORKDIR /app/ClgSite
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=build /app/ClgSite/target/*.jar app.jar

EXPOSE 8080
CMD ["java","-jar","app.jar"]