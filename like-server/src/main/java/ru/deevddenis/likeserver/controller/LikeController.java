package ru.deevddenis.likeserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.deevddenis.likeserver.service.LikeService;

@RestController
@RequiredArgsConstructor
public class LikeController {

    public final LikeService likeService;

    public final static String LIKE = "/like/{name}";

    @Value("${eureka.instance.instance-id}")
    private String port;

    @PostMapping(LIKE)
    public ResponseEntity<String> like(@PathVariable("name") String name) {
        likeService.incrementLikeAndView(name);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("like" + port);
    }
}
