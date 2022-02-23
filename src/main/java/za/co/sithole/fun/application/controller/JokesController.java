package za.co.sithole.fun.application.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.sithole.fun.api.dto.Joke;
import za.co.sithole.fun.application.dto.JokeDto;
import za.co.sithole.fun.application.persistence.entity.JokeEntity;
import za.co.sithole.fun.application.persistence.repository.JokeRepository;
import za.co.sithole.fun.application.service.JokeService;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.co.sithole.fun.api.dto.Joke;
import za.co.sithole.fun.application.dto.JokeDto;
import za.co.sithole.fun.application.persistence.entity.JokeEntity;
import za.co.sithole.fun.application.persistence.repository.JokeRepository;
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
