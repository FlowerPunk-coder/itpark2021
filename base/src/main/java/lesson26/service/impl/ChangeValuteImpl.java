package lesson26.service.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lesson26.service.ChangeValute;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ChangeValuteImpl implements ChangeValute {

    private Map<String, BigDecimal> listOfValute = Collections.emptyMap();

    @PostConstruct
    @SneakyThrows
    void init() {
        DocumentContext context = JsonPath.parse(new URL("https://www.cbr-xml-daily.ru/daily_json.js"));
        List<Map<String, Object>> values = context.read("$.Valute.*", List.class);
        listOfValute = values.stream()
                .map(e -> Pair.of(e.get("CharCode").toString(), new BigDecimal(e.get("Value").toString())))
                .collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
    }


    @Override
    public Optional<BigDecimal> getValueByCode(String code) {
        return Optional.ofNullable(listOfValute.get(code));
    }
}
