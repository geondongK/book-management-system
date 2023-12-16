FROM openjdk:17-jdk-slim
EXPOSE 8080
ADD /build/libs/*.jar book-management-system-service.jar
#ADD target/book-management-system-service.jar book-management-system-service.jar
ENTRYPOINT ["java","-jar","/book-management-system-service.jar"]