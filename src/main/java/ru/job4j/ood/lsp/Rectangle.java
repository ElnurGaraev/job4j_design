package ru.job4j.ood.lsp;

public class Rectangle {
    int length;
    int width;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSquare() {
        return width * length;
    }
}

class Test {
    static Rectangle getReact() {
        return new Rectangle(); /*при возврате объекта квадрат new Square и расчете площади,
        метод родителя будет работать не корректно*/
    }

    public static void main(String[] args) {
        Rectangle rectangle = getReact();
        rectangle.setLength(5);
        rectangle.setWidth(10);
        int sqr = rectangle.getSquare(); /*здесь будет возвращено 25 при расчете площади квадрата,
        т.е поведение родителя изменилось*/
    }
}

class Square extends Rectangle {
    public void setLength(int length) {
        this.length = length;
        width = length;
    }

    public void setWidth(int width) {
        this.width = width;
        length = width;
    }

}
