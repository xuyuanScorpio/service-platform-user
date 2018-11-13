package com.service.platform.user;


import com.service.platform.user.config.ThriftServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = { "com.service.platform.user.mapper", "com.service.platform.user.thriftClient" })
public class UserMainApplication {

    private static ThriftServer thriftServer;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(UserMainApplication.class, args);

        try {
            thriftServer = context.getBean(ThriftServer.class);
            thriftServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
