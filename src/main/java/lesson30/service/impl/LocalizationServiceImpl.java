package lesson30.service.impl;


import lesson30.config.AppProp;
import lesson30.service.LocalizationService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {


    private final MessageSource messageSource;
    private final Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource, AppProp appProp) {
        this.messageSource = messageSource;
        this.locale = appProp.getLocale();
    }

    @Override
    public String localize(String key, Object... vars) {
        return messageSource.getMessage(key, vars, locale);
    }
}
