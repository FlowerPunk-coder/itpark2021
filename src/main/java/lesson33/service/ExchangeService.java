package lesson33.service;

import java.math.BigDecimal;

public interface ExchangeService {

    BigDecimal exchange(BigDecimal exchangeValue, String valuteCode);

}
