package lesson29.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Locale;

@Data
@Component
@Validated
@ConfigurationProperties("application")
public class ApplicationProperties {

    private Locale locale;

}
