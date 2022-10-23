FROM openjdk:11
MAINTAINER metin
VOLUME /tmp
EXPOSE 8080
ADD target/readingIsGood-0.0.1.jar readingIsGood.jar
ENTRYPOINT ["java","-jar","/readingIsGood.jar"]