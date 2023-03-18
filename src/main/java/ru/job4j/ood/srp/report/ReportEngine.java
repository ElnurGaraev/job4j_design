package ru.job4j.ood.srp.report;


import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String generateAccount(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(converter.convert(Currency.RUB, employee.getSalary(), Currency.USD))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String generateHR(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> lists = store.findBy(filter);
        Comparator<Employee> comparator = (o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary());
        Collections.sort(lists, comparator.reversed());
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : lists) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public String generateIT(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append("Name, Hired, Fired, Salary")
                    .append(System.lineSeparator())
                    .append(employee.getName()).append(", ")
                    .append(dateTimeParser.parse(employee.getHired())).append(", ")
                    .append(dateTimeParser.parse(employee.getFired())).append(", ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
