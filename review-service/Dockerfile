FROM openjdk:17.0.1
VOLUME /tmp
ADD target/review-service.jar review-service.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "/review-service.jar"]