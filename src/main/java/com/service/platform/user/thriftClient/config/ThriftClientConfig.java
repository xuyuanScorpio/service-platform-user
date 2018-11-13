package com.service.platform.user.thriftClient.config;

import com.service.platform.user.thriftClient.domain.ThriftClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThriftClientConfig {

    @Value("${thriftClient.host}")
    private String host;
    @Value("${thriftClient.port}")
    private int port;
    @Value("${thriftClient.timeout}")
    private int timeout;

    @Bean(initMethod = "init")
    public ThriftClient thriftClient() {
        ThriftClient thriftClient = new ThriftClient();
        thriftClient.setHost(host);
        thriftClient.setPort(port);
        thriftClient.setTimeout(timeout);
        return thriftClient;
    }


}
