FROM maven:3.8.3-openjdk-17 AS build
COPY . /temp/app
RUN mvn -f /temp/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17.0.1
COPY --from=build /temp/app/target/review-service.jar /usr/local/lib/review-service.jar
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "/usr/local/lib/review-service.jar","--spring.profiles.active=prod"]