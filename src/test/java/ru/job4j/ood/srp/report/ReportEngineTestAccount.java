package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineTestAccount {
    @Test
    public void whenConvertToUSD() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parse = new ReportDateTimeParser();
        CurrencyConverter converterToUSD = new InMemoryCurrencyConverter();
        Employee em = new Employee("Ivan", now, now,
                converterToUSD.convert(Currency.RUB, 200, Currency.USD));
        store.add(em);
        Report engine = new ReportEngine(store, parse);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(em.getName()).append(" ")
                .append(parse.parse(em.getHired())).append(" ")
                .append(parse.parse(em.getFired())).append(" ")
                .append(em.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generate(e -> true)).isEqualTo(expected.toString());
    }
}