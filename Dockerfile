FROM openjdk:11

COPY target/OnlineContact-0.0.1.jar /online.contact.jar

ENTRYPOINT ["java", "-jar", "/online.contact.jar"]