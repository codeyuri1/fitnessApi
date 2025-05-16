FROM gradle:7.6-jdk21 AS builder
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN gradle clean shadowJar -x test --no-daemon
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
ARG JWT_SECRET="thisisaverysecurejwtkeywith32chars"
ENV JWT_GENERATOR_SIGNATURE_SECRET=${JWT_SECRET}
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
