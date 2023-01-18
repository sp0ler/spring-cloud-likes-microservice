package ru.deevddenis.likeserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String TEST = "/test";
    @Value("${eureka.instance.instance-id}")
    private String port;

    @GetMapping(TEST)
    public ResponseEntity<String> test() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("test" + port);
    }
}
