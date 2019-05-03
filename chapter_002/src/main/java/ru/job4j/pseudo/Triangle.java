package ru.job4j.pseudo;
/**
 * @author Mikhail Popov (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append(System.lineSeparator());
        pic.append(System.lineSeparator());
        pic.append("  +  ");
        pic.append(System.lineSeparator());
        pic.append(" + + ");
        pic.append(System.lineSeparator());
        pic.append("+++++");
        return pic.toString();
    }
}
