package com.zhss.demo.dubbo.nacos;

import com.zhss.demo.dubbo.nacos.api.ServiceA;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Reference(version = "1.0.0",
            interfaceClass = ServiceA.class,
            cluster = "failfast")
    private ServiceA serviceA;

    //http://localhost:8080/greet?name=john
    @GetMapping("/greet")
    public String greet(String name) {
        return serviceA.greet(name);
    }

}
