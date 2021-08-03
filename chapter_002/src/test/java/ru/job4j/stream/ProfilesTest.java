package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тесты логики в классе Profiles
 * @author Popov Mikhail (m.popov83@gmail.com)
 */
public class ProfilesTest {
    @Test
    public void whenCollectAddress() {
        Address addr1 = new Address("Tagil", "Lenina", 1, 20);
        Address addr2 = new Address("Ekb", "Bebelya", 30, 25);
        Address addr3 = new Address("Tagil", "Lenina", 1, 20);

        List<Profile> profile  = Arrays.asList(new Profile(addr1, "Ivanov"),
                                                new Profile(addr2, "Petrov"),
                                                new Profile(addr3, "Sidorov"));
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(profile);
        List<Address> expected = Arrays.asList(addr2, addr1);
        assertThat(rsl, is(expected));
    }
}
