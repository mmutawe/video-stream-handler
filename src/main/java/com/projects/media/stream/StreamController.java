package com.projects.media.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StreamController {

    private final StreamService streamService;

    @GetMapping(value="video/{title}", produces = "video/mov")
    public Mono<Resource> retrieveVideoStream(@PathVariable("title") String videoTitle, @RequestHeader("range") String range){

        System.out.println("***");
        log.info("*** Video range in bytes: {}", range);

        return streamService.getVideo(videoTitle);
    }
}
