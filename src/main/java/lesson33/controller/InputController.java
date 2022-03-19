package lesson33.controller;

import lesson33.dto.ResultDto;
import lesson33.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class InputController {



    private final ExchangeService exchangeService;


    @PostMapping("/valute")
    public ResultDto exchangeValute(BigDecimal exchangeValue, String valuteCode) {
        return new ResultDto(valuteCode, exchangeService.exchange(exchangeValue, valuteCode));
    }


}
