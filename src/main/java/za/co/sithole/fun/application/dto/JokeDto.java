package za.co.sithole.fun.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class JokeDto {
    private Integer id;
    private String jokeId;
    private LocalDate date;
    private String text;
    private String title;
    private Integer racial;
    private String category;
}
