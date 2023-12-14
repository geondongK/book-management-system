FROM openjdk:17-jdk
EXPOSE 8080
ADD target/book-management-system.jar book-management-system.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/book-management-system.jar"]