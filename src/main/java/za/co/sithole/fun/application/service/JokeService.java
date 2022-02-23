package za.co.sithole.fun.application.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import za.co.sithole.fun.application.dto.JokeDto;
import za.co.sithole.fun.application.persistence.repository.JokeRepository;

import java.util.List;
import java.util.stream.Collectors;

import static za.co.sithole.fun.application.service.JokeMapper.mapToDto;
import static za.co.sithole.fun.application.service.JokeMapper.mapToEntity;

@Service
@AllArgsConstructor
public class JokeService {
    private JokeRepository jokeRepository;

    public void save(JokeDto joke) {
        jokeRepository.save(mapToEntity(joke));
    }

    public List<JokeDto> getAllJokes() {
        var all = jokeRepository.findAll();
        return all.stream().map(JokeMapper::mapToDto).collect(Collectors.toList());
    }

    public JokeDto getJokeById(Integer jokeId) {
        return mapToDto(jokeRepository.findById(jokeId).orElseThrow(() ->
                new RuntimeException(String.format("Joke with id %d not found", jokeId))));
    }

    public void updateJoke(Integer jokeId, JokeDto joke) {
        jokeRepository.findById(jokeId).orElseThrow(() ->
                new RuntimeException(String.format("Joke with id %d not found", jokeId)));
        jokeRepository.save(mapToEntity(joke));
    }

    public void deleteJokeById(Integer jokeId) {
        jokeRepository.deleteById(jokeId);
    }

    private String generateJokeId() {
        return RandomStringUtils.randomAlphabetic(9);
    }

}