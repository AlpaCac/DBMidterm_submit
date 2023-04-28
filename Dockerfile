FROM openjdk:17.0.2-slim
MAINTAINER AlpaCa
ADD DBMidterm/DBMidterm.jar /root
ADD ./dataset /root
WORKDIR /root
EXPOSE 8080 3306
ENTRYPOINT java -jar DBMidterm.jar
