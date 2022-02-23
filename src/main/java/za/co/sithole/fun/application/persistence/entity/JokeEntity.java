package za.co.sithole.fun.application.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JokeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String jokeId;

    private LocalDateTime fetchTime;
    @CreatedDate
    private LocalDate creationDate;
    private String text;
    private String title;
    private Integer racial;
    private String category;
}
