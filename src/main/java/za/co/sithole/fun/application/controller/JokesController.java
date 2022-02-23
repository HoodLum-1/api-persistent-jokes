package za.co.sithole.fun.application.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sithole.fun.application.dto.JokeDto;
import za.co.sithole.fun.application.service.JokeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/jokes")
@Slf4j
public class JokesController {

    private JokeService jokeService;


    @GetMapping(path = "/all-jokes")
    public List<JokeDto> getAllJokes() {
        return jokeService.getAllJokes();
    }

    @GetMapping(path = "/joke/{id}")
    public JokeDto getJokeById(@PathVariable("id") final Integer id) {
        log.info("Getting Joke by Id={{}]", id);
        return jokeService.getJokeById(id);
    }

    @PostMapping(path = "/save-joke")
    public void save(@RequestBody JokeDto joke) {
        jokeService.save(joke);
    }

    @PutMapping(path = "/update-joke/{id}")
    public void update(@PathVariable final Integer id, @RequestBody JokeDto joke) {
        jokeService.updateJoke(id, joke);
    }

    @DeleteMapping(path = "/delete-joke/{id}")
    public void deleteJoke(@PathVariable("id") final Integer id) {
        log.info("Deleting Joke by Id={{}]", id);
        jokeService.deleteJokeById(id);
    }
}
