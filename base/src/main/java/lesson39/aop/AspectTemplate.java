package lesson39.aop;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AspectTemplate {

        private final RestTemplate restTemplate;

        @Before("execution(* lesson35.service.imp.CountryServiceImpl.*(..))")
        public void logMethod(JoinPoint joinPoint) {
                final URI aspectUri = UriComponentsBuilder.newInstance()
                        .scheme("http")
                        .host("localhost")
                        .port(8034)
                        .path("/logger")
                        .queryParam("method", joinPoint.getSignature().getName())
                        .build(String.class);

                log.info("Вызов метода по запросу {}", aspectUri);

                restTemplate.getForObject(aspectUri, Void.class);
        }


}
