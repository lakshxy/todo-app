FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN ./mvnw clean install

CMD ["java", "-jar", "target/todo-0.0.1-SNAPSHOT.jar"]
