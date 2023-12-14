FROM openjdk:17-jdk
EXPOSE 8080
ADD target/build/libs/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]