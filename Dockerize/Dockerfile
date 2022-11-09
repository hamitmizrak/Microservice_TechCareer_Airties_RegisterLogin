FROM adoptopenjdk/openjdk11
ARG JAR_FILE=TechCareerAirtiesRegisterLogin-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} micro.jar
ENTRYPOINT [ "java","-jar","/micro.jar" ]
