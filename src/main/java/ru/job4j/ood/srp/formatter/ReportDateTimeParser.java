package ru.job4j.ood.srp.formatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@XmlRootElement(name = "ReportDateTimeParser")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportDateTimeParser implements DateTimeParser<Calendar> {
    @XmlAttribute
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public String parse(Calendar calendar) {
        return DATE_FORMAT.format(calendar.getTime());
    }
}
