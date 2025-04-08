FROM openjdk:11-jdk-slim
COPY . .
RUN ./mvnw clean install -DskipTests
CMD ["java", "-jar", "target/todo-0.0.1-SNAPSHOT.jar"]
