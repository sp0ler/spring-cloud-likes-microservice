package ru.deevddenis.likeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableDiscoveryClient
public class LikeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LikeServerApplication.class, args);
    }

}
