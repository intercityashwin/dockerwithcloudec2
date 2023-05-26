FROM openjdk:8u191-jre-alpine3.8
##FROM openjdk:19
RUN apk add curl jq
WORKDIR /usr/share/seleniumdocker
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD testng.xml testng.xml
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh
ENTRYPOINT sh healthcheck.sh
##ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -Dbrowser=$browser -Dhubhost=$hubhost org.testng.TestNG $module