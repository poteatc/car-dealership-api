package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
@Configuration annotation ----

1. Designates a Configuration Class:
    - A class annotated with @Configuration is treated as a source of bean definitions for the Spring IoC (Inversion of Control) container.
    - It replaces XML-based configuration with Java-based configuration.

2. Enables Dependency Injection:
    - Beans defined in a @Configuration class can be injected into other components using annotations like @Autowired or constructor injection.

3. Provides a Singleton Scope:
    - Beans defined in a @Configuration class are created as singletons by default. Spring ensures that the same instance is reused wherever the bean is injected.
 */
@Configuration
public class DatabaseConfiguration {
    private BasicDataSource basicDataSource;

    @Bean
    public DataSource dataSource() {
        return basicDataSource;
    }

    @Autowired
    public DatabaseConfiguration(@Value("${spring.datasource.url}") String url,
                                 @Value("${spring.datasource.username}") String username,
                                 @Value("${spring.datasource.password}") String password) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }
}
