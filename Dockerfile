FROM adoptopenjdk/openjdk11

COPY build/libs/*SNAPSHOT.jar medicalrecord.jar
ENTRYPOINT ["java","-jar","/medicalrecord.jar"]