package me.willwei.springboot.dubbo.dubboprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import me.willwei.springboot.dubbo.DemoService;
import org.springframework.beans.factory.annotation.Value;

/**
 * DefaultDemoService
 *
 * @author leiming
 * @date 2019-02-13
 */
@Service(version = "1.0.0")
public class DefaultDemoService implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

}
