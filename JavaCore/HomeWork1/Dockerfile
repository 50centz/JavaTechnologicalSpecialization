FROM bellsoft/liberica-openjdk-alpine:11.0.10 as BuildProject
WORKDIR /app
COPY ./java ./src
RUN mkdir ./out
RUN javac -sourcepath ./src -d out ./src/ru/geekbrains/seminar1/sample/Main.java
