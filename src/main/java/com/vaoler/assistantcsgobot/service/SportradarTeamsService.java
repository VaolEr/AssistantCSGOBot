package com.vaoler.assistantcsgobot.service;


import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.dto.TeamsListGetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class SportradarTeamsService {
    //NaVi = 904
    private final RestTemplate restTemplate;

    private final BotTeamsService botTeamsService;

    @Value("${app.sportradar.get-csgo-teams-list}")
    private String SPORTRADAR_API_GET_TEAMS_URL;

    @PostConstruct
    public void sportradarGetTeamsList() {

        log.info("Sportradar.com GET Teams List...");
//        log.debug(SPORTRADAR_API_GET_TEAMS_URL);

        TeamsListGetResponse response = restTemplate.getForObject(SPORTRADAR_API_GET_TEAMS_URL, TeamsListGetResponse.class);
        assert response != null;
        List<TeamTo> teamTos = response.getTeams();
//        for (TeamTo team:teamTos) {
//            //log.info(botTeamsService.create(team).toString());
//            log.debug(team.toString());
//        }
        teamTos.forEach(teamTo -> log.debug(teamTo.toString()));
//        log.info(response.getStatusCode().toString());
        log.info("Teams list got successful!");
    }

//    public void abiosGetTeamByName(String name){
//        ENDPOINT_URL = SPORTRADAR_API_PATH + ENDPOINT_TEAMS;
//
//        Formatter formatter = new Formatter();
//        formatter.format("?filter=abbreviation=%s", name);
//        String teamName  = formatter.toString();
//
//        log.info("Abios get team by name " + teamName);
//
//        HttpHeaders headers = new HttpHeaders();
//        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
//        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        log.debug(ENDPOINT_URL+teamName);
//
//        ResponseEntity<TeamTo[]> response = restTemplate.exchange(
//                ENDPOINT_URL + teamName,
//                HttpMethod.GET,
//                entity,
//                TeamTo[].class
//        );
//
//        TeamTo[] teamTos = Objects.requireNonNull(response.getBody());
//        if(teamTos.length > 0) {
//            for (TeamTo team : teamTos) {
//                log.info(team.toString());
//            }
//        } else {
//            log.info("There is no teams with name " + teamName);
//        }
//        log.info(response.getStatusCode().toString());
//    }

//    public void abiosGetTeamById(Integer id){
//        ENDPOINT_URL = SPORTRADAR_API_PATH + ENDPOINT_TEAMS;
//
//        Formatter formatter = new Formatter();
//        formatter.format("/%d", id);
//        String teamId  = formatter.toString();
//
//        log.debug("Abios get team by id " + teamId);
//
//        HttpHeaders headers = new HttpHeaders();
//        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
//        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        log.debug(ENDPOINT_URL+teamId);
//
//        ResponseEntity<TeamTo> response = restTemplate.exchange(
//                ENDPOINT_URL + teamId,
//                HttpMethod.GET,
//                entity,
//                TeamTo.class
//        );
//        TeamTo teamTo = Objects.requireNonNull(response.getBody());
//        log.debug(teamTo.toString());
//        log.info(response.getStatusCode().toString());
//    }

//    public void abiosGetTeamRosters(Integer id){
//        ENDPOINT_URL = SPORTRADAR_API_PATH + ENDPOINT_TEAMS;
//
//        Formatter formatter = new Formatter();
//        formatter.format("/%d/rosters", id);
//        String teamId  = formatter.toString();
//
//        log.info("Abios get rosters for team " + teamId);
//
//        HttpHeaders headers = new HttpHeaders();
//        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
//        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        log.info(ENDPOINT_URL+teamId);
//
//        ResponseEntity<RosterTo[]> response = restTemplate.exchange(
//                ENDPOINT_URL + teamId,
//                HttpMethod.GET,
//                entity,
//                RosterTo[].class
//        );
//        RosterTo[] rosterTos = Objects.requireNonNull(response.getBody());
//        for (RosterTo rosterTo:rosterTos) {
//            log.info(rosterTo.toString());
//        }
//        log.info(response.getStatusCode().toString());
//    }

//    public void abiosGetTeamSeries(Integer id){
//        ENDPOINT_URL = SPORTRADAR_API_PATH + ENDPOINT_TEAMS;
//
//        Formatter formatter = new Formatter();
//        formatter.format("/%d/series", id);
//        String teamId  = formatter.toString();
//
//        log.info("Abios get series for team " + teamId);
//
//        HttpHeaders headers = new HttpHeaders();
//        //headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        //headers.set("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0");
//        headers.set(ABIOS_SECRET_HEADER_NAME, ABIOS_SECRET_KEY);
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        log.info(ENDPOINT_URL+teamId);
//
//        ResponseEntity<SerieTo[]> response = restTemplate.exchange(
//                ENDPOINT_URL + teamId,
//                HttpMethod.GET,
//                entity,
//                SerieTo[].class
//        );
//        SerieTo[] serieTos = Objects.requireNonNull(response.getBody());
//        for (SerieTo serieTo:serieTos) {
//            log.info(serieTo.toString());
//        }
//        log.info(response.getStatusCode().toString());
//    }

}
