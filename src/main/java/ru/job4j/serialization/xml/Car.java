package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)

public class Car {
    @XmlAttribute
    private boolean accident;

    @XmlAttribute
    private int kilometres;
    private String model;
    private Owner owner;

    private String[] description;

    public Car() {
    }

    public Car(boolean accident, int kilometres, String model, Owner owner, String[] description) {
        this.accident = accident;
        this.kilometres = kilometres;
        this.model = model;
        this.owner = owner;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" + "accident=" + accident
                + ", kilometres=" + kilometres
                + ", model='" + model + '\''
                + ", owner=" + owner
                + ", description=" + Arrays.toString(description)
                + '}';
    }

    public static void main(String[] args) throws Exception {
         final Car car = new Car(false, 15000, "Toyota",
                new Owner("Petrov"), new String[] {"white", "economy"});
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Car result = (Car) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
