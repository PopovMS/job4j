package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> newListAcc = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = users.keySet()
                                    .stream()
                                    .filter(s -> s.getPassport().equals(passport))
                                    .findFirst();
        if (rsl.isPresent()) {
                return rsl;
        } else {
            return Optional.empty();
        }
    }

    /**
     * Метод ищет пользователя по паспорту, затем, если найден, ищет счет по реквизитам
     * @param passport принимаемый параметр паспортных данных
     * @param requisite принимаемый номер счета
     * @return возвращает найденый счет пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            Optional<Account> rsl = users.get(user.get())
                                            .stream()
                                            .filter(s -> s.getRequisite().equals(requisite))
                                            .findFirst();
            return rsl;
        }
        return Optional.empty();
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
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        if (srcAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            Optional<Account> destAcc = findByRequisite(destPassport, destRequisite);
            if (destAcc.isPresent()) {
                srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
                destAcc.get().setBalance(destAcc.get().getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}