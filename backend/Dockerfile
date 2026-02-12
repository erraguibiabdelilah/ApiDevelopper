FROM openjdk:21-ea-1-jdk-oracle
# Copier le jar
COPY ./target/backend*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
