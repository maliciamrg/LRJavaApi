package com.maliciamrg.lrcat.controller.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.maliciamrg.lrcat")
@EntityScan(basePackages = "com.maliciamrg.lrcat.model")
//@EnableJpaRepositories(basePackages = "com.maliciamrg.lrcat.repository")
public class DomainConfiguration {
}
