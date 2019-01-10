package com.learn.demo.tomcat;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

/**
 * @ClassName: EmbeddedServletContainerCustomizer
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/5 11:26
 * @Version: 1.0
 */
//@Configuration
public class JettyConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    public void customize(ConfigurableServletWebServerFactory factory) {
        System.err.println(factory);
        JettyServletWebServerFactory factory1 = (JettyServletWebServerFactory) factory;
        factory1.setPort(1234);
    }
}

// 另一种方式，泛型直接规定 JettyServletWebServerFactory
//public class JettyConfiguration implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {
//
//    public void customize(JettyServletWebServerFactory factory) {
//        System.err.println(factory);
//        JettyServletWebServerFactory factory1 = (JettyServletWebServerFactory) factory;
//        factory1.setPort(12347);
//    }
//}
