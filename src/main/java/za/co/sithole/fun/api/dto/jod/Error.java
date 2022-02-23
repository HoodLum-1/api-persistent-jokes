package za.co.sithole.fun.api.dto.jod;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error {
    private int code;
    private String message;
}
