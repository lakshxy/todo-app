# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Copy the project files into the Docker image
COPY . .

# Run Maven build, skipping tests
RUN ./mvnw clean install -DskipTests

# Run the jar file after build
CMD ["java", "-jar", "target/todo-0.0.1-SNAPSHOT.jar"]
