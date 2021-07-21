package com.vaoler.assistantcsgobot.service;

import com.vaoler.assistantcsgobot.dto.DailyScheduleTo;
import com.vaoler.assistantcsgobot.dto.SportEventTo;
import com.vaoler.assistantcsgobot.dto.TeamScheduleResponseTo;
import com.vaoler.assistantcsgobot.dto.TeamTo;
import com.vaoler.assistantcsgobot.repository.TeamsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static com.vaoler.assistantcsgobot.util.TeamsUtil.getTeamFromTeamTo;

@Slf4j
@Service
@RequiredArgsConstructor
public class InitDatabaseService {

    private final SportradarService sportradarService;
    private final TeamsRepository teamsRepository;

    //TODO init database
    //@PostConstruct
    public void initTeamsTable(){
        List<TeamTo> teamTos = sportradarService.sportradarGetTeamsList();
        for(TeamTo teamTo:teamTos){
            String teamApiId = teamTo.getApiId();
            if(teamsRepository.getTeamByApiId(teamApiId).isEmpty()){
                teamsRepository.save(getTeamFromTeamTo(teamTo));
            }
        }
    }

    //@PostConstruct
    public void testGetDailySchedule(){
//        DailyScheduleTo dailyScheduleToForToday = sportradarService.getDailyScheduleToForToday();
//        for(SportEventTo event: dailyScheduleToForToday.getSportEvents()){
//            log.info(event.toString());
//        }
//        Calendar date = new GregorianCalendar();
//        date.set(2021,6,15);
//        DailyScheduleTo dailyScheduleToByDate = sportradarService.getDailyScheduleToByDate(date);
//        for(SportEventTo event: dailyScheduleToByDate.getSportEvents()){
//            log.info(event.toString());
//        }
        TeamScheduleResponseTo teamSchedule = sportradarService.getTeamSchedule("sr:competitor:220606");
        for(SportEventTo event: teamSchedule.getSchedule()){
            log.info(event.toString());
        }

    }
}
