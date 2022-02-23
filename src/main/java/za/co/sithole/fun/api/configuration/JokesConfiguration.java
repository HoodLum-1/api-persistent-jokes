package za.co.sithole.fun.api.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@AllArgsConstructor
public class JokesConfiguration {

    private JokesApiProperties apiProperties;

    @Bean("jokesRestTemplate")
    public RestTemplate jokesRestTemplate() {
        return new RestTemplateBuilder()
                .defaultHeader("X-JokesOne-Api-Secret", apiProperties.getApiKey())
                .rootUri(apiProperties.getBaseUrl())
                .build();
    }
}
