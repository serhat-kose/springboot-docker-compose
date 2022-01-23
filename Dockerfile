FROM openjdk:11
LABEL maintainer = "serhat-kose"
ADD target/springboot-docker-0.0.1-SNAPSHOT.jar springboot-docker.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","springboot-docker.jar"]
