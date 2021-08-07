package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Модель банковской системы
 * В системе можно производить следующие действия:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BankService {
    /**
     * Хранение пользователей и их счетов осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход модель данных пользователя и, если в коллекции users такого нет,
     * добавляет его с созданием пустого счета
     * @param user модель данных пользователя
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход переменную паспорта юзера и счет,
     * ищет в пользователя по паспорту и, если есть, ищет у пользователя такой же счет, как принимаемый
     * в параметрах. Если отсутствует, то добавляет счет пользователю
     * @param passport переменная паспорта
     * @param account принимает добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> newListAcc = users.get(user);
            if (!newListAcc.contains(account)) {
                newListAcc.add(account);
            }
        }
    }

    /**
     * Метот принимает переменную паспорта и ищет по ней пользователя в коллекции
     * @param passport переменная паспорта
     * @return возвращает найденого пользователя
     */
    public User findByPassport(String passport) {
        return users.keySet()
                    .stream()
                    .filter(s -> s.getPassport().equals(passport))
                    .findFirst()
                    .orElse(null);
    }

    /**
     * Метод ищет пользователя по паспорту, затем, если найден, ищет счет по реквизитам
     * @param passport принимаемый параметр паспортных данных
     * @param requisite принимаемый номер счета
     * @return возвращает найденый счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                        .stream()
                        .filter(s -> s.getRequisite().equals(requisite))
                        .findFirst()
                        .orElse(null);
        }
        return null;
    }

    /**
     * Метот переводит деньги с одного счета пользователя на другой счет (того же или другого пользователя)
     * @param srcPassport  паспорт пользователя с которого списываем средства
     * @param srcRequisite реквизиты счета с которого списываем
     * @param destPassport паспорт пользователя которому переводим средства
     * @param destRequisite реквизиты счета на который переводим средства
     * @param amount количество переводимых средств
     * @return возвращает true при успешной операции перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        if (srcAcc != null && srcAcc.getBalance() >= amount) {
            Account destAcc = findByRequisite(destPassport, destRequisite);
            if (destAcc != null) {
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                destAcc.setBalance(destAcc.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}