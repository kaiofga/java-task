FROM openjdk:11

COPY target/*.jar /usr/app/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-XX:TieredStopAtLevel=1", "-noverify", "-Dspring.jmx.enabled=false", "-jar","/usr/app/app.jar"]