/*package lesson30.config;



import lesson30.service.LocalizationService;
import lombok.SneakyThrows;
import org.jline.utils.AttributedString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.shell.jline.PromptProvider;

import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

@Configuration
@EnableConfigurationProperties
@EntityScan("lesson30.model")
public class AppConfig {

    @Bean
    public ResourceBundle resourceBundle (AppProp applicationProperties) {
        return ResourceBundle.getBundle("message", applicationProperties.getLocale());
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasename("message");
        return messageSource;
    }

    @Bean
    @SneakyThrows
    public PromptProvider promptProvider(LocalizationService localizationService) {
        return () -> new AttributedString(localizationService.localize("start"));
    }
}*/
