package ru.job4j.serialization.java;

import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.Callable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
            final Contact contact = new Contact(123456, "+7 (111) 111-11-11");
            File tempfile = Files.createTempFile(null, null).toFile();
            try (FileOutputStream fos = new FileOutputStream(tempfile);
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos)) {
                oos.writeObject(contact);
            }
            try (FileInputStream fis = new FileInputStream(tempfile);
            ObjectInputStream ois =
                    new ObjectInputStream(fis)) {
                final Contact contactFromFile = (Contact) ois.readObject();
                System.out.println(contactFromFile);
            }
        }
    }

