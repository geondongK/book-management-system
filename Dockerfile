FROM openjdk:17-jdk
RUN apk add crul
VOLUME /tmp
EXPOSE 8080
ADD target/book-management-system-service.jar book-management-system-service.jar
ENTRYPOINT ["java","-jar","/book-management-system-service.jar"]