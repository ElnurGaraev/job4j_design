package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportEngineTestIT {
    @Test
    public void whenReportEngineForIt() {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser parse = new ReportDateTimeParser();
        Employee em = new Employee("Ivan", now, now, 170);
        store.add(em);
        ReportEngine engine = new ReportEngine(store, parse);
        StringBuilder expected = new StringBuilder()
                .append("Name, Hired, Fired, Salary")
                .append(System.lineSeparator())
                .append(em.getName()).append(", ")
                .append(parse.parse(em.getHired())).append(", ")
                .append(parse.parse(em.getFired())).append(", ")
                .append(em.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generateIT(e -> true)).isEqualTo(expected.toString());
    }
}