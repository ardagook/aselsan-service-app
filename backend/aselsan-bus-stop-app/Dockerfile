FROM bellsoft/liberica-openjdk-debian:latest
LABEL maintainer="author@javatodev.com"
WORKDIR D:\aselsan-service-app\backend\aselsan-bus-stop-app
COPY target/aselsan-bus-stop-app-0.0.1-SNAPSHOT.jar aselsan-bus-stop.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "aselsan-bus-stop.jar"]
