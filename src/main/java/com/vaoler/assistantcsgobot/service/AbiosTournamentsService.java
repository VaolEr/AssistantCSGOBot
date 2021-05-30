package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.abiosTo.TeamTo;
import com.vaoler.assistantcsgobot.dto.abiosTo.TournamentTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class AbiosTournamentsService {

    private final RestTemplate restTemplate;
    private final BotEventsService botEventsService;

    @Value("${app.abios.api.base_path}")
    private String ABIOSGAMING_API_PATH;

    @Value("${app.abios-api.atlas.endpoints.tournaments}")
    private String ENDPOINT_TOURNAMENTS;

    private String ENDPOINT_URL;

    @Value("${app.abios.secret_key}")
    private String ABIOS_SECRET_KEY;

    private final String ABIOS_SECRET_HEADER_NAME = "Abios-Secret";

    @PostConstruct
    public void abiosGetTeams() {
        ENDPOINT_URL = ABIOSGAMING_API_PATH + ENDPOINT_TOURNAMENTS;

        log.info("Abios getTeams...");
        log.info(ENDPOINT_URL);
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<TournamentTo[]> response = restTemplate.exchange(
                ENDPOINT_URL,
                HttpMethod.GET,
                entity,
                TournamentTo[].class
        );
        TournamentTo[] tournamentTos = Objects.requireNonNull(response.getBody());
        for (TournamentTo tournament:tournamentTos) {
            log.info(tournament.toString());
            log.info(botEventsService.create(tournament).toString());
        }
        log.info(response.getStatusCode().toString());
    }
}
