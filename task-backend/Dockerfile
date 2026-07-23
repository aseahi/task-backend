FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY . .
RUN apt-get update && apt-get install -y gradle
RUN gradle bootJar
EXPOSE 8080
CMD ["java", "-jar", "build/libs/*.jar"]