FROM openjdk:8-jdk-alpine
RUN addgroup -S custtech && adduser -S custtech -G custtech
USER custtech:custtech
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]