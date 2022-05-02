package lesson33.service.impl;

import lesson26.service.ChangeValute;
import lesson33.service.ExchangeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ChangeValute changeValute;

    public ExchangeServiceImpl(ChangeValute changeValute) {
        this.changeValute = changeValute;
    }

    @Override
    public BigDecimal exchange(BigDecimal exchangeValue, String valuteCode) {

        BigDecimal multi = changeValute.getValueByCode(valuteCode).orElse(new BigDecimal(0));

        return multi.multiply(exchangeValue);
    }
}
