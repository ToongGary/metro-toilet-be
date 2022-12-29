FROM gradle:7.6 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle build

FROM openjdk:17-slim
EXPOSE 8080
COPY --from=build /app/build/libs/metro-toilet-*-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app/app.jar"]