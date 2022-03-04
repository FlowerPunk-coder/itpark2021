package lesson26.service;

import java.math.BigDecimal;
import java.util.Optional;

public interface ChangeValute {

    Optional<BigDecimal> getValueByCode(String code);

}
