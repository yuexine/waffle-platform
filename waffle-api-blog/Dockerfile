# 指定基础镜像
FROM openjdk:8-jre
# 作者信息
MAINTAINER wuyuexin <yuexine@gmail.com>
# 数据卷
VOLUME /tmp
# 构建过程中的变量
ARG JAR_FILE
# 复制
COPY target/${JAR_FILE} /usr/share/app/app.jar
# 启动容器时执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/app/app.jar"]