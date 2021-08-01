package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
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
        Address addr2 = new Address("Tagil", "Mira", 30, 25);
        Profile prof = new Profile(addr1, "Ivanov");
        Profile prof2 = new Profile(addr2, "Petrov");
        List<Profile> profile  = new ArrayList<>();
        profile.add(prof);
        profile.add(prof2);
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(profile);
        List<Address> expected = new ArrayList<>();
        expected.add(addr1);
        expected.add(addr2);
        assertThat(rsl, is(expected));
    }
}
