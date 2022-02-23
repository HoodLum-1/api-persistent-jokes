package za.co.sithole.fun.api.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import za.co.sithole.fun.api.configuration.JokesApiProperties;
import za.co.sithole.fun.api.dto.jod.JokeOfTheDayResponse;
import za.co.sithole.fun.api.dto.jokes.JokesResponse;
import za.co.sithole.fun.application.persistence.entity.JokeEntity;
import za.co.sithole.fun.application.persistence.repository.JokeRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class JokesService {

    private RestTemplate jokesRestTemplate;
    private JokesApiProperties apiProperties;
    private JokeRepository jokeRepository;

    public JokeOfTheDayResponse getJokeOfTheDay() {
        try {
            var jod = jokesRestTemplate.getForObject(apiProperties.getJokeOfTheDay(),
                    JokeOfTheDayResponse.class);
            assert jod != null;
            jod.getContents().getJokes().forEach(jokeOfTheDay ->
                    jokeRepository.findByJokeId(jokeOfTheDay.getJoke().getId()).ifPresentOrElse(jokeEntity ->
                            log.info("Joke with id {} already exists", jokeEntity.getJokeId()), () -> {
                        var jokeEntity = new JokeEntity();
                        jokeEntity.setRacial(jokeOfTheDay.getJoke().getRacial());
                        jokeEntity.setTitle(jokeOfTheDay.getJoke().getTitle());
                        jokeEntity.setText(jokeOfTheDay.getJoke().getText());
                        jokeEntity.setJokeId(jokeOfTheDay.getJoke().getId());
                        jokeEntity.setCategory(jokeOfTheDay.getCategory());
                        jokeEntity.setFetchTime(LocalDateTime.now());
                        jokeEntity.setCreationDate(LocalDate.now());


                        log.debug("{}", jod);
                        jokeRepository.save(jokeEntity);
                    }));
            return jod;
        } catch (final HttpClientErrorException e) {
            log.error("Error retrieving JokeEntity of the day", e);
        }
        return null;
    }

    public JokesResponse getJokes() {
        var jokes = jokesRestTemplate.getForObject(apiProperties.getJokes(), JokesResponse.class);
        int[] intArray = new int[1];

        try {
            assert jokes != null;
            jokes.getContents().getJokes().forEach(newJoke ->
                    jokeRepository.findByJokeId(newJoke.getId()).ifPresentOrElse(jokeEntity ->
                            log.info("Joke with id {} already exists", jokeEntity.getJokeId()), () -> {
                        if (intArray[0] != 20) {
                            var jokeEntity = new JokeEntity();
                            jokeEntity.setTitle(newJoke.getTitle());
                            jokeEntity.setJokeId(newJoke.getId());
                            jokeEntity.setCreationDate(LocalDate.now());
                            jokeEntity.setRacial(newJoke.getRacial());
                            jokeEntity.setText(newJoke.getText());
                            jokeEntity.setFetchTime(LocalDateTime.now());

                            jokeRepository.save(jokeEntity);
                            intArray[0]++;
                        }
                        log.info("Joke {}", newJoke);
                    }));

            log.debug("{}", jokes);
        } catch (Exception e) {
            log.error("Error retrieving JokeEntity of Jokes", e);
        }
        return jokes;
    }
}
