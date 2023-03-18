package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JSONReportEngineTest {
    @Test
    public void whenJsonReport() throws Exception {
        Store store = new MemStore();
        Gson gson = new GsonBuilder().create();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parse = new ReportDateTimeParser();
        Employee employee = new Employee("Ivan", now, now, 110);
        store.add(employee);
        Report engine = new JSONReportEngine(store, parse, new Gson());
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(gson.toJson(employee))
                .append(System.lineSeparator());
        assertThat(engine.generate(e -> true)).isEqualTo(expected.toString());
    }
}