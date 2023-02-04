package ru.job4j.serialization.json;

import org.json.JSONObject;

public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);

        System.out.println(new JSONObject(b));
    }
}
