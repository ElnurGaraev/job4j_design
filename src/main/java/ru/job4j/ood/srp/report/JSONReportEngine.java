package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class JSONReportEngine implements Report {
    private Store store;
    private DateTimeParser<Calendar> dateTimeParser;
    private Gson gson = new GsonBuilder().create();

    public JSONReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser, Gson gson) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.gson = gson;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JSONReportEngine engine = new JSONReportEngine(store, dateTimeParser, gson);
        StringBuilder jsonText = new StringBuilder();
        jsonText.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            jsonText.append(engine.gson.toJson(employee))
                    .append(System.lineSeparator());
        }
        return jsonText.toString();
    }
}
