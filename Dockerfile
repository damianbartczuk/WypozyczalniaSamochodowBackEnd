FROM openjdk:8-jdk-alpine
# EXPOSE 8080
# ARG JAR_FILE=target/wypozyczalnia-samochodow-0.0.1-SNAPSHOT.jar
# ADD ${JAR_FILE} wypozyczalnia-samochodow-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","/wypozyczalnia-samochodow-0.0.1-SNAPSHOT.jar"]
VOLUME /app
ADD /target/wypozyczalnia-samochodow-0.0.1-SNAPSHOT.jar wypozyczalnia-samochodow-0.0.1-SNAPSHOT.jar
EXPOSE 8580
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/TodoApp.jar"]
ENTRYPOINT ["java","-jar","/wypozyczalnia-samochodow-0.0.1-SNAPSHOT.jar"]