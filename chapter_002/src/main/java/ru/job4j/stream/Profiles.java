package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс принимает поток профилей пользователей и создает List извлеченных
 * из профилей данных Address
 */
public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                       .map(profile -> profile.getAddress())
                       .collect(Collectors.toList());
    }
}
