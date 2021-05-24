package com.vaoler.assistantcsgobot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class AbiosAuthenticationService {

    private final RestTemplate restTemplate;

    @Value("${app.abios.api-link}")
    private String ABIOSGAMING_API_LINK;

    @Value("${app.abios.secret_key}")
    private String ABIOS_SECRET_KEY;

    private final String ABIOS_SECRET_HEADER_NAME = "Abios-Secret";

    //@PostConstruct
    public void abiosAuthenticate(){
        log.info("Abios authentication...");
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange(
                ABIOSGAMING_API_LINK,
                HttpMethod.GET,
                entity,
                String.class
        );
        log.info(response.getBody());
        log.info(response.getStatusCode().toString());
    }

}
