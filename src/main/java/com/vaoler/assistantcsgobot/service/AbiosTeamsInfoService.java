package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.abiosTo.RosterTo;
import com.vaoler.assistantcsgobot.dto.abiosTo.SerieTo;
import com.vaoler.assistantcsgobot.dto.abiosTo.TeamTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class AbiosTeamsInfoService {
    //NaVi = 904
    private final RestTemplate restTemplate;

    private final BotTeamsService botTeamsService;

    @Value("${app.abios.api.base_path}")
    private String ABIOSGAMING_API_PATH;

    @Value("${app.abios-api.atlas.endpoints.teams}")
    private String ENDPOINT_TEAMS;

    private String ENDPOINT_URL;

    @Value("${app.abios.secret_key}")
    private String ABIOS_SECRET_KEY;

    private final String ABIOS_SECRET_HEADER_NAME = "Abios-Secret";

    @PostConstruct
    public void abiosGetTeams() {
        ENDPOINT_URL = ABIOSGAMING_API_PATH + ENDPOINT_TEAMS;

        log.info("Abios getTeams...");
        log.info(ENDPOINT_URL);
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<TeamTo[]> response = restTemplate.exchange(
                ENDPOINT_URL,
                HttpMethod.GET,
                entity,
                TeamTo[].class
        );
        TeamTo[] teamTos = Objects.requireNonNull(response.getBody());
        for (TeamTo team:teamTos) {
            log.info(botTeamsService.create(team).toString());
            log.info(team.toString());
        }
        log.info(response.getStatusCode().toString());

    }

    public void abiosGetTeamByName(String name){
        ENDPOINT_URL = ABIOSGAMING_API_PATH + ENDPOINT_TEAMS;

        Formatter formatter = new Formatter();
        formatter.format("?filter=abbreviation=%s", name);
        String teamName  = formatter.toString();

        log.info("Abios get team by name " + teamName);

        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        log.debug(ENDPOINT_URL+teamName);

        ResponseEntity<TeamTo[]> response = restTemplate.exchange(
                ENDPOINT_URL + teamName,
                HttpMethod.GET,
                entity,
                TeamTo[].class
        );

        TeamTo[] teamTos = Objects.requireNonNull(response.getBody());
        if(teamTos.length > 0) {
            for (TeamTo team : teamTos) {
                log.info(team.toString());
            }
        } else {
            log.info("There is no teams with name " + teamName);
        }
        log.info(response.getStatusCode().toString());
    }

    public void abiosGetTeamById(Integer id){
        ENDPOINT_URL = ABIOSGAMING_API_PATH + ENDPOINT_TEAMS;

        Formatter formatter = new Formatter();
        formatter.format("/%d", id);
        String teamId  = formatter.toString();

        log.debug("Abios get team by id " + teamId);

        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        log.debug(ENDPOINT_URL+teamId);

        ResponseEntity<TeamTo> response = restTemplate.exchange(
                ENDPOINT_URL + teamId,
                HttpMethod.GET,
                entity,
                TeamTo.class
        );
        TeamTo teamTo = Objects.requireNonNull(response.getBody());
        log.debug(teamTo.toString());
        log.info(response.getStatusCode().toString());
    }

    public void abiosGetTeamRosters(Integer id){
        ENDPOINT_URL = ABIOSGAMING_API_PATH + ENDPOINT_TEAMS;

        Formatter formatter = new Formatter();
        formatter.format("/%d/rosters", id);
        String teamId  = formatter.toString();

        log.info("Abios get rosters for team " + teamId);

        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        log.info(ENDPOINT_URL+teamId);

        ResponseEntity<RosterTo[]> response = restTemplate.exchange(
                ENDPOINT_URL + teamId,
                HttpMethod.GET,
                entity,
                RosterTo[].class
        );
        RosterTo[] rosterTos = Objects.requireNonNull(response.getBody());
        for (RosterTo rosterTo:rosterTos) {
            log.info(rosterTo.toString());
        }
        log.info(response.getStatusCode().toString());
    }

    public void abiosGetTeamSeries(Integer id){
        ENDPOINT_URL = ABIOSGAMING_API_PATH + ENDPOINT_TEAMS;

        Formatter formatter = new Formatter();
        formatter.format("/%d/series", id);
        String teamId  = formatter.toString();

        log.info("Abios get series for team " + teamId);

        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        log.info(ENDPOINT_URL+teamId);

        ResponseEntity<SerieTo[]> response = restTemplate.exchange(
                ENDPOINT_URL + teamId,
                HttpMethod.GET,
                entity,
                SerieTo[].class
        );
        SerieTo[] serieTos = Objects.requireNonNull(response.getBody());
        for (SerieTo serieTo:serieTos) {
            log.info(serieTo.toString());
        }
        log.info(response.getStatusCode().toString());
    }

}
