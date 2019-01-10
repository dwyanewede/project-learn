package com.learn.demo.tomcat;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;


//@Configuration
public class TomcatConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    // class org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
    @Override
    public void customize(ConfigurableServletWebServerFactory server){

        System.err.println(server.getClass());
        System.err.println("-------------自定义Configuration---------------");
//        server.setPort(9090);
        if (server instanceof TomcatServletWebServerFactory){
            TomcatServletWebServerFactory factory = (TomcatServletWebServerFactory) server;
            // 创建 connector
            Connector connector = new Connector();
            connector.setPort(12345);
            connector.setURIEncoding("utf-8");
            factory.addAdditionalTomcatConnectors(connector);
            // 创建 context
        }
    }
}

/*@Configuration
public class TomcatConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    // class org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
    @Override
    public void customize(TomcatServletWebServerFactory factory) {

        System.err.println(factory.getClass());
        System.err.println("-------------自定义Configuration---------------");
//        server.setPort(9090);
        // 创建 connector
        Connector connector = new Connector();
        connector.setPort(12345);
        connector.setURIEncoding("iso-8859-1");
        factory.addAdditionalTomcatConnectors(connector);
        // 创建 context

//        Tomcat tomcat = new Tomcat();
//        try {
//            tomcat.getService().wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}*/
