package za.co.sithole.fun.api.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@ConfigurationProperties("jokes.api")
public class JokesApiProperties {

    private String apiKey;
    private String cron;
    private String baseUrl;
    private String jokeOfTheDay;
    private String jokes;
}
