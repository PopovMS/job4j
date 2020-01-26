package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Mikail Popov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
}