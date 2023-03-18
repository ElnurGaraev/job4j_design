package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {
    private Store store;
    private DateTimeParser<Calendar> dateTimeParser;

    public XmlReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringBuilder xmlText = new StringBuilder();
        try (StringWriter writer = new StringWriter()) {
            for (Employee employee : store.findBy(filter)) {
                marshaller.marshal(employee, writer);
                xmlText.append(writer.getBuffer());
                xmlText.append(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlText.toString();
    }
}
