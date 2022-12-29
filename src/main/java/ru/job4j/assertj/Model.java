package ru.job4j.assertj;

public class Model {
    private int top;
    private double num;
    private String line;
    private boolean condition;

    public Model(int top, double num, String line, boolean condition) {
        this.top = top;
        this.num = num;
        this.line = line;
        this.condition = condition;
    }

    public int getTop() {
        return top;
    }

    public double getNum() {
        return num;
    }

    public String getLine() {
        return line;
    }

    public boolean isCondition() {
        return condition;
    }
}
