package ru.job4j.pseudo;

/**
 * @author Mikhail Popov (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] arg) {
        new Paint().draw(new Triangle());
        new Paint().draw(new Square());
    }
}