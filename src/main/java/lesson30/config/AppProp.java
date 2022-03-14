package lesson30.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Locale;

@Data
@Component
@Validated
@ConfigurationProperties("application.crud")
public class AppProp {

    private Locale locale;
}
