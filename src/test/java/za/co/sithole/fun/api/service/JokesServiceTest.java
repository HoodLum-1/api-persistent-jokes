package za.co.sithole.fun.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import za.co.sithole.fun.api.configuration.JokesApiProperties;
import za.co.sithole.fun.api.dto.jod.JokeOfTheDayResponse;
import za.co.sithole.fun.api.dto.jokes.JokesResponse;
import za.co.sithole.fun.application.persistence.entity.JokeEntity;
import za.co.sithole.fun.application.persistence.repository.JokeRepository;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

class JokesServiceTest {

    @Mock
    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

    @Mock
    private JokeRepository jokeRepository = Mockito.mock(JokeRepository.class);

    @Mock
    private JokesApiProperties apiProperties = Mockito.mock(JokesApiProperties.class);

    @InjectMocks
    private JokesService jokesService = new JokesService(restTemplate, apiProperties, jokeRepository);

    @Test
    public void testJokeOfTheDay_from_mocked_response() {
        final var URL = "/jod";
        Mockito.when(apiProperties.getJokeOfTheDay()).thenReturn(URL);
        Mockito.when(jokeRepository.save(any(JokeEntity.class))).thenReturn(new JokeEntity());
        Mockito.when(restTemplate.getForObject(eq(URL), any())).thenReturn(getJodResponseFromFile());

        var jokeOfTheDay = jokesService.getJokeOfTheDay();
        assertNotNull(jokeOfTheDay);
    }

    @Test
    public void testJokes_from_mocked_response() {
        final var URL = "/joke/list";
        Mockito.when(apiProperties.getJokes()).thenReturn(URL);
        Mockito.when(jokeRepository.save(any(JokeEntity.class))).thenReturn(new JokeEntity());
        Mockito.when(restTemplate.getForObject(eq(URL), any())).thenReturn(getJokesResponseFromFile());
        var jokesResponse = jokesService.getJokes();
        assertNotNull(jokesResponse);

    }

    @SneakyThrows
    private JokeOfTheDayResponse getJodResponseFromFile() {
        return new ObjectMapper().readValue(Files.
                        readString(Path.of("src/test/resources/samples/jod/jod1.json")),
                JokeOfTheDayResponse.class);
    }

    @SneakyThrows
    private JokesResponse getJokesResponseFromFile() {
        return new ObjectMapper().readValue(Files
                .readString(Path.of("src/test/resources/samples/jokes/jokes1.json")),
                JokesResponse.class);
    }

    @Test
    public void testStructure_of_JodJson() {
        JokeOfTheDayResponse jodResponseFromFile = getJodResponseFromFile();
        assertNotNull(jodResponseFromFile);
    }

    @Test
    public void testStructure_of_JokesJson() {
        JokesResponse jodResponseFromFile = getJokesResponseFromFile();
        assertNotNull(jodResponseFromFile);
    }


}