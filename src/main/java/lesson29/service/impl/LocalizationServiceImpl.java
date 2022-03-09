package lesson29.service.impl;

import lesson29.config.ApplicationProperties;
import lesson29.service.LocalizationService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    private MessageSource messageSource;
    private Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource, ApplicationProperties applicationProperties) {
        this.messageSource = messageSource;
        this.locale = applicationProperties.getLocale();
    }

    @Override
    public String localize(String key, Object... vars) {
        return messageSource.getMessage(key, vars, locale);
    }
}
