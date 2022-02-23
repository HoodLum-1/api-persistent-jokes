package za.co.sithole.fun.api.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import za.co.sithole.fun.api.configuration.JokesApiProperties;
import za.co.sithole.fun.api.dto.Joke;
import za.co.sithole.fun.api.dto.NewJoke;
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

            log.debug("{}", jod);
            jokeRepository.save(new JokeEntity());

            return jod;
        } catch (final HttpClientErrorException e) {
            log.error("Error retrieving JokeEntity of the day", e);
        }
        return null;
    }

    public JokesResponse getJokes() {
        var jokes = jokesRestTemplate.getForObject(apiProperties.getJokes(), JokesResponse.class);

        try{

            jokes.getContents().getJokes().forEach(newJoke -> {
                var jokeEntity = new JokeEntity();
                jokeEntity.setTitle(newJoke.getTitle());
                jokeEntity.setJokeId(newJoke.getId());
                jokeEntity.setCreationDate(LocalDate.now());
                jokeEntity.setRacial(newJoke.getRacial());
                jokeEntity.setText(newJoke.getText());
                jokeEntity.setFetchTime(LocalDateTime.now());

                jokeRepository.save(jokeEntity);

                log.info("Joke {}", newJoke);
            });

            log.debug("{}", jokes);
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        return jokes;
    }

}
