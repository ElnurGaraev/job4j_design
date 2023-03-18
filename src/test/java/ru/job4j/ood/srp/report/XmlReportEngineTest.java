package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XmlReportEngineTest {
    @Test
    public void whenGetXmlReport() throws Exception {
        Store store = new MemStore();
        Calendar now = Calendar.getInstance();
        DateTimeParser<Calendar> parse = new ReportDateTimeParser();
        Employee employee = new Employee("Ivan", now, now, 100);
        store.add(employee);
        Report report = new XmlReportEngine(store, parse);
        StringBuilder expected = new StringBuilder();
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employee, writer);
            expected.append(writer.getBuffer())
                    .append(System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(report.generate(e -> true)).isEqualTo(expected.toString());
    }
}