FROM openjdk:22

ADD target/ecommerceproject-0.0.1-SNAPSHOT.jar ecommerceproject-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","ecommerceproject-0.0.1-SNAPSHOT.jar"]