package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan(basePackages = {"com.dao"})
public class SpringbootSchemaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) throws UnknownHostException {
		Logger log = LoggerFactory.getLogger(SpringbootSchemaApplication.class);
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootSchemaApplication.class, args);
		ConfigurableEnvironment env = applicationContext.getEnvironment();
		String contextPath = env.getProperty("server.servlet.context-path");
		log.info(
						"=============================================================================================================================================================\n" +
						"应用程序启动成功! 点击下方链接开始体验吧~:\n\t" +
						"管理后台地址: \thttp://localhost:{}{}/admin/dist/index.html\n\t" +
						"前台地址: \thttp://localhost:{}{}/front/index.html\n" +
						"===============================================================================================================================================================\n",
				env.getProperty("server.port"),contextPath,
				env.getProperty("server.port"),contextPath
		);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(SpringbootSchemaApplication.class);
    }
}
