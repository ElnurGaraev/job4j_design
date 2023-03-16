package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;


class ReportEngineTestHR {
    @Test
    public void whenSalaryFromLessToMore() {
        Store store = new MemStore();
        DateTimeParser<Calendar> parse = new ReportDateTimeParser();
        Employee em1 = new Employee("Ivan", 100);
        Employee em2 = new Employee("Petr", 150);
        store.add(em1);
        store.add(em2);
        ReportEngine engine = new ReportEngine(store, parse);
        StringBuilder exp = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(em2.getName()).append(" ")
                .append(em2.getSalary())
                .append(System.lineSeparator())
                .append(em1.getName()).append(" ")
                .append(em1.getSalary())
                .append(System.lineSeparator());
        assertThat(engine.generateHR(e -> true)).isEqualTo(exp.toString());
    }
}