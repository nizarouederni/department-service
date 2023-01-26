FROM openjdk:17-alpine

WORKDIR /opt/app

COPY target/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 5054