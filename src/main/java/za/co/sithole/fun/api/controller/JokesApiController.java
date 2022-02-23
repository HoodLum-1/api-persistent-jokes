package za.co.sithole.fun.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sithole.fun.api.dto.jod.JokeOfTheDayResponse;
import za.co.sithole.fun.api.dto.jokes.JokesResponse;
import za.co.sithole.fun.api.service.JokesService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/jokes-api")
@Slf4j
public class JokesApiController {

    private JokesService jokesService;

    @GetMapping(path = "/jod")
    public JokeOfTheDayResponse getJokeOfTheDay() { return jokesService.getJokeOfTheDay(); }

    @GetMapping(path = "/jokes")
    public JokesResponse getJokes() { return jokesService.getJokes(); }

}
