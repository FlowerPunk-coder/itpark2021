package exam.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EntityScan({"exam"})
@ComponentScan({"exam"})
@RequiredArgsConstructor
public class ExamAppConfig implements WebMvcConfigurer {




    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(StringUtils.delimitedListToStringArray("https://ITpark.itpark2021/", ",", " "))
                .allowCredentials(true)
                .allowedMethods("GET, POST, PUT, PATCH, DELETE, OPTIONS");
    }



}
