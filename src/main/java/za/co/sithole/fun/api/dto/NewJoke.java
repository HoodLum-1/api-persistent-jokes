package za.co.sithole.fun.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NewJoke {
    private String id;
    private Integer length;
    private Integer clean;
    private Integer racial;
    private String title;
    private String text;
}
