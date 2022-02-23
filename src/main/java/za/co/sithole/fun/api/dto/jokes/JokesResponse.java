package za.co.sithole.fun.api.dto.jokes;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.sithole.fun.api.dto.Contents;
import za.co.sithole.fun.api.dto.NewJoke;
import za.co.sithole.fun.api.dto.Success;

@Data
@NoArgsConstructor
public class JokesResponse {
    private Success success;
    private Contents<NewJoke> contents;
}
