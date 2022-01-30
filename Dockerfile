FROM openjdk:11

COPY target/OnlineContact-0.0.1.jar /online.contact.jar

CMD ["java", "-jar", "/online.contact.jar"]