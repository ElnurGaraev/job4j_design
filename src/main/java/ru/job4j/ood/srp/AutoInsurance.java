package ru.job4j.ood.srp;

public class AutoInsurance implements InsuranceService {
    @Override
    public String makeInsurance(String name, int years) {
        StringBuilder builder = new StringBuilder();
        builder.append("Имя: ").append(name).append(" Срок действия: ").append(years);
        return builder.toString();
    }

    @Override
    public String printInsurance(String insurance) {
        return insurance;
    }
}
