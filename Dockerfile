# ---- build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests clean package

# ---- runtime stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target/temperature-converter.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
