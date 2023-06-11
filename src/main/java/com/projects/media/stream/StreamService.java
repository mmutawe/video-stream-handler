package com.projects.media.stream;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StreamService {

    private static final String FORMAT="classpath:videos/%s.mov";
    private final ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String fileName){
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, fileName)));
    }
}
