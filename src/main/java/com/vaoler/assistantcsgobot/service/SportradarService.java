package com.vaoler.assistantcsgobot.service;


import com.vaoler.assistantcsgobot.dto.DailyScheduleTo;
import com.vaoler.assistantcsgobot.dto.TeamScheduleResponseTo;
import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.dto.TeamsListGetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SportradarService {

    @Value("${app.sportradar.get-csgo-teams-list}")
    private String SPORTRADAR_API_GET_TEAMS_URL;

    @Value("${app.sportradar.csgo.en.schedules}")
    private String SPORTRADAR_API_SCHEDULES;
    @Value("${app.sportradar.csgo.en.teams}")
    private String SPORTRADAR_API_TEAMS;
    @Value("${app.sportradar.json.api_key}")
    private String SPORTRADAR_JSON_API_KEY;

    public List<TeamTo> sportradarGetTeamsList() {

        log.info("===>>> Sportradar.com GET Teams List...");

        TeamsListGetResponse webClientResponse = WebClient.create().get()
                        .uri(SPORTRADAR_API_GET_TEAMS_URL)
                        .retrieve()
                            .onStatus(HttpStatus::is4xxClientError,
                                error -> Mono.error(new RuntimeException("API not found")))
                            .onStatus(HttpStatus::is5xxServerError,
                                error -> Mono.error(new RuntimeException("Server is not responding")))
                        .bodyToMono(TeamsListGetResponse.class)
                        .block();

        assert webClientResponse != null;
        List<TeamTo> teamTos = webClientResponse.getTeams();
        teamTos.forEach(teamTo -> log.debug(teamTo.toString()));
        log.info("===>>> Teams list got successful!");
        return teamTos;
    }

    @Cacheable("dailyScheduleByDate")
    public DailyScheduleTo getDailyScheduleToByDate(Calendar eventsDate){
        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(eventsDate.getTime());
        String sb = SPORTRADAR_API_SCHEDULES + date + "/schedule" + SPORTRADAR_JSON_API_KEY;
        log.info("===>>> Sportradar.com GET Schedule for the date " + simpleDateFormat);

        DailyScheduleTo webClientResponse = WebClient.create().get()
                .uri(sb)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(DailyScheduleTo.class)
                .block();

        log.info("===>>> Daily schedule got successful!");

        return webClientResponse;
    }


    @Scheduled(cron = "0 0 0 * * *")                     // every day at 00:00 update the daily schedule 0 0 0 * * *
    public DailyScheduleTo getDailyScheduleToForToday(){
        var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(Calendar.getInstance().getTime());
        String sb = SPORTRADAR_API_SCHEDULES + date + "/schedule" + SPORTRADAR_JSON_API_KEY;
        log.info("===>>> Sportradar.com GET Schedule for today " + date);

        DailyScheduleTo webClientResponse = WebClient.create().get()
                .uri(sb)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(DailyScheduleTo.class)
                .block();

        log.info("===>>> Daily schedule for today got successful!");

        return webClientResponse;
    }

    @Cacheable("teamSchedule")
    public TeamScheduleResponseTo getTeamSchedule(String teamApiId){
        String sb = SPORTRADAR_API_TEAMS + teamApiId + "/schedule" + SPORTRADAR_JSON_API_KEY;
        log.info("===>>> Sportradar.com GET Schedule for team " + teamApiId);

        TeamScheduleResponseTo webClientResponse = WebClient.create().get()
                .uri(sb)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatus::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(TeamScheduleResponseTo.class)
                .block();

        log.info("===>>> Schedule for team " + teamApiId + " got successful!");

        return webClientResponse;
    }
}
