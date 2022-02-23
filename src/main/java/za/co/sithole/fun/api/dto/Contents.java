package za.co.sithole.fun.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Contents<T> {
    // Note: Making use of Generics because Contents is not standard/consistent
    private List<T> jokes;
    private String copyright;
}
