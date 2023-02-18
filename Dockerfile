FROM adoptopenjdk/openjdk11:alpine-slim

LABEL nome="denuncia-api"

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring  

WORKDIR /app

COPY target/denuncia-0.0.1-SNAPSHOT.jar /app


EXPOSE 8080

ENTRYPOINT ["java", "-jar", "denuncia-0.0.1-SNAPSHOT.jar"]

