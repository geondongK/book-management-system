FROM openjdk:17-jdk
EXPOSE 8080
ADD target/book-management-system-service.jar book-management-system-service.jar
ENTRYPOINT ["java","-jar","/book-management-system-service.jar"]