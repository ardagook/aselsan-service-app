FROM bellsoft/liberica-openjdk-debian:latest
VOLUME /tmp
LABEL maintainer="author@javatodev.com"
ADD target/aselsan-bus-stop-app-0.0.1-SNAPSHOT.jar aselsan-bus-stop.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar", "aselsan-bus-stop.jar"]
