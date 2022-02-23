package za.co.sithole.fun.application.scheduler;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import za.co.sithole.fun.api.service.JokesService;

@Component
@AllArgsConstructor
@Profile("dev")
public class JokesScheduler {

    private JokesService jokesService;

    @Scheduled(cron = "0 0 0 ? * * *") //runs once everyday
    public void runForrest() {
        jokesService.getJokeOfTheDay();
    }
}
