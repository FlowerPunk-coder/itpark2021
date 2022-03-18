package lesson33.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"lesson26.service", "lesson33"})
public class AppConfig {
}
