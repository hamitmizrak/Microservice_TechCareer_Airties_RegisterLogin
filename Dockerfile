FROM adoptopenjdk/openjdk11
EXPOSE 5555
ARG JAR_FILE=TechCareerAirtiesRegisterLogin-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]