FROM openjdk:17.0.2-slim
MAINTAINER AlpaCa
ADD DBMidterm/DBMidterm.jar /root
ADD ./departments.csv /root
ADD ./dept_emp.csv /root
ADD ./dept_manager.csv /root
ADD ./employees.csv /root
ADD ./titles.csv /root
WORKDIR /root
EXPOSE 8080 3306
ENTRYPOINT java -jar DBMidterm.jar
