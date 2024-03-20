package com.maliciamrg.lrjavaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LrJavaApiApplication {

	private static final String HTTP_DEFAULT_PORT = "8080" ;
	private static final Logger logger = LoggerFactory.getLogger(LrJavaApiApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		final Environment env = SpringApplication.run(LrJavaApiApplication.class, args).getEnvironment();
		logApplicationStartup(env);

		logger.trace("---==[ trace  ]==---");
		logger.debug("---==[ debug ]==---");
		logger.info("---==[  info   ]==---");
		logger.warn("---==[  warn   ]==---");
		logger.error("---==[ error  ]==---");
		logger.info("Start");
	}

	private static void logApplicationStartup(Environment env) throws UnknownHostException {
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		final String serverPort = Optional.ofNullable(env.getProperty("server.port")).orElse(HTTP_DEFAULT_PORT);
		String contextPath = env.getProperty("server.servlet.context-path");
		if (StringUtils.isEmpty(contextPath)) {
			contextPath = "/";
		}
		final String hosttAddress = InetAddress.getLocalHost().getHostAddress();
		final String ipOutsideDocker = env.getProperty("spring.ipOutsideDocker");
		logger.info("\n---------------------------------------------------------------\n\t" +
						"Application '{} ({})' is running!\n\tAccess URLs:\n\t" +
						"Local: \t\t{}://localhost:{}{}\n\t" +
						"External: \t{}://{}:{}{}\n\t" +
						"Ip for Testing: \t{}\n\t (manual)" +
						"Profile(s): \t{}\n\t" +
						"---------------------------------------------------------------\n\t"+
						"Swagger: \t{}://{}:{}{}swagger-ui.html\n\t" +
						"Swagger for testing: \t{}swagger-ui.html\n\t" ,
				env.getProperty("spring.application.name"),
				env.getProperty("application.version"),
				protocol,
				serverPort,
				contextPath,
				protocol,
				hosttAddress,
				serverPort,
				contextPath,
				ipOutsideDocker,
				env.getActiveProfiles(),
				protocol,
				hosttAddress,
				serverPort,
				contextPath,
				ipOutsideDocker);
	}
}
