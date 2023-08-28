# Build Stage
FROM ubuntu:20.04 AS build

# Set the working directory inside the container
WORKDIR /app

# Install necessary build tools and dependencies
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk maven

# Copy the Maven project file and source code
COPY pom.xml .
COPY src/ src/

# Build the project using Maven and skip tests
RUN mvn clean package -DskipTests

# Run Stage
FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file from the build stage
COPY --from=build /app/target/app.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
