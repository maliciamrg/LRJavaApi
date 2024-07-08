package com.maliciamrg.lrcat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.maliciamrg.lrcat.repository")
@EntityScan(basePackages = "com.maliciamrg.lrcat.model")
public class LrcatApplication {

    public static final String HTTP_DEFAULT_PORT = "8080";
    private static final Logger logger = LoggerFactory.getLogger(LrcatApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        final Environment env = SpringApplication.run(LrcatApplication.class, args).getEnvironment();
        logApplicationStartup(env);

        logger.trace("---==[ trace  ]==---");
        logger.debug("---==[ debug ]==---");
        logger.info("---==[  info   ]==---");
        logger.warn("---==[  warn   ]==---");
        logger.error("---==[ error  ]==---");
        logger.info("Start.................");
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
        final String ipOutsideDocker = env.getProperty("application.ipWan");
        logger.info("\n\t---------------------------------------------------------------\n\t" +
                        "Application '{} ({})' is running!\n\t" +
                        "Access URLs:\n\t" +
                        "  Local: \t\t{}://localhost:{}{}\n\t" +
                        "  External: \t{}://{}:{}{}\n\t" +
                        "  IpWan: \t\t{}://{}\t (manual)\n\t" +
                        "Profile(s): \t{}\n\t" +
                        "---------------------------------------------------------------\n\t" +
                        "Swagger: \t{}://{}:{}{}swagger-ui/index.html\n\t" +
                        "Swagger IpWan: \t{}://{}/swagger-ui/index.html\n\t",
                env.getProperty("spring.application.name"),
                env.getProperty("application.version"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hosttAddress,
                serverPort,
                contextPath,
                protocol,
                ipOutsideDocker,
                env.getActiveProfiles(),
                protocol,
                hosttAddress,
                serverPort,
                contextPath,
                protocol,
                ipOutsideDocker);
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propsConfig
                = new PropertySourcesPlaceholderConfigurer();
        propsConfig.setLocation(new ClassPathResource("git.properties"));
        propsConfig.setIgnoreResourceNotFound(true);
        propsConfig.setIgnoreUnresolvablePlaceholders(true);
        return propsConfig;
    }
}
