FROM eclipse-temurin:19-jdk-alpine as build
ARG JAR_FILE=TechCareerAirtiesRegisterLogin-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} register.jar
ENTRYPOINT [ "java","-jar","/register.jar" ]
EXPOSE 1111
