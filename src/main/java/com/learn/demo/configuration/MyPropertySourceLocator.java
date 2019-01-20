package com.learn.demo.configuration;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import java.util.HashMap;

/**
 * 自定义扩展PropertySource加载
 */
@Configuration
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public class MyPropertySourceLocator implements PropertySourceLocator {
        @Override
        public PropertySource<?> locate(Environment environment) {

            HashMap<String, Object> source = new HashMap<>();
            source.put("server.port","9090");
            MapPropertySource mapPropertySource = new MapPropertySource("my-property-source",source);
            return mapPropertySource;
        }
    }