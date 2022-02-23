package za.co.sithole.fun.application.service;

import za.co.sithole.fun.application.dto.JokeDto;
import za.co.sithole.fun.application.persistence.entity.JokeEntity;

public class JokeMapper {

    public static JokeEntity mapToEntity(JokeDto joke) {
        return JokeEntity.builder()
                .id(joke.getId())
                .jokeId(joke.getJokeId())
                .category(joke.getCategory())
                .racial(joke.getRacial())
                .creationDate(joke.getDate())
                .text(joke.getText())
                .title(joke.getTitle())
                .build();
    }

    public static JokeDto mapToDto(JokeEntity joke) {
        return JokeDto.builder()
                .jokeId(joke.getJokeId())
                .category(joke.getCategory())
                .racial(joke.getRacial())
                .text(joke.getText())
                .title(joke.getTitle())
                .build();
    }
}
