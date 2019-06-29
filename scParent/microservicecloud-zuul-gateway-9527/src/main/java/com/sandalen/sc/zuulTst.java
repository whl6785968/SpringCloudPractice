package com.sandalen.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class zuulTst {
    public static void main(String[] args) {
        SpringApplication.run(zuulTst.class,args);
    }
}
