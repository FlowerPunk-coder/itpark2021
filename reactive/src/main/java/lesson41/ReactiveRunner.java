package lesson41;


import lesson41.model.Country;
import lesson41.repository.CountryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@EnableMongoRepositories
@SpringBootApplication
public class ReactiveRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRunner.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> composedRoutes(CountryRepository countryRepository) {
        return route()
                .GET("/api/countries", accept(APPLICATION_JSON),
                        request -> ok().contentType(APPLICATION_JSON).body(countryRepository.findAll(), Country.class)
                )
                .DELETE("/api/countries/{code}",
                        request -> countryRepository.deleteById(request.pathVariable("code")).flatMap(v -> ok().build())
                ).build();
    }
}
