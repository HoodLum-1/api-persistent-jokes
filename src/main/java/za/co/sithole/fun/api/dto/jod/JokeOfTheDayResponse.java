package za.co.sithole.fun.api.dto.jod;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import za.co.sithole.fun.api.dto.Contents;
import za.co.sithole.fun.api.dto.Success;

@Data
@ToString
@NoArgsConstructor
public class JokeOfTheDayResponse {
    private Success success;
    private Contents<JokeOfTheDay> contents;
}
