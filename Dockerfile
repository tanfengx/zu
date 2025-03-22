# 使用一个基础的 Java 镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制项目的 JAR 文件到容器中
COPY target/*.jar app.jar

# 暴露应用运行的端口，这里的端口要和 application.yml 里配置的端口一致
EXPOSE 8080

# 启动 Spring Boot 应用
CMD ["java", "-jar", "app.jar"]