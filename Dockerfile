FROM openjdk:11
WORKDIR app
COPY build/libs/Shoping-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","Shoping-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
