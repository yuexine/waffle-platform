From openjdk:8-jre
MAINTAINER wuyuexin <yuexine@gmail.com>
VOLUME /tmp
ARG JAR_FILE
COPY target/${JAR_FILE} /usr/share/app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/app/app.jar"]