# Use the official Alpine Linux image as the base image
FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file into the container
COPY target/app.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]