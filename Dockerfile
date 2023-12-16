FROM openjdk:17-jdk-slim
ADD /build/libs/*.jar app.jar
#ADD target/book-management-system-service.jar book-management-system-service.jar
ENTRYPOINT ["java","-jar","/book-management-system-service.jar"]