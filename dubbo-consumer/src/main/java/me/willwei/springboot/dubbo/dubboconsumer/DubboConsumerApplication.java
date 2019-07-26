package me.willwei.springboot.dubbo.dubboconsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import me.willwei.springboot.dubbo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "1.0.0", url = "dubbo://localhost:12345")
    private DemoService demoService;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(demoService.sayHello("mercyblitz"));
        };
    }

    public static void main(String[] args) {
//        SpringApplication.run(DubboConsumerApplication.class).close();
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}

