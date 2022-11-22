FROM openjdk:11

ADD target/springpractice-0.0.1-SNAPSHOT.jar springBoot.jar

EXPOSE 8989

ENTRYPOINT ["java", "-jar","/springBoot.jar"]