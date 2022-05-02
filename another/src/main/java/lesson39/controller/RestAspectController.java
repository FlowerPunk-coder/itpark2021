package lesson39.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RestAspectController {

    @GetMapping("/logger")
    public void aspect(@RequestParam String method) {
        log.info("Вызываемый метод: {}", method);
    }
}
