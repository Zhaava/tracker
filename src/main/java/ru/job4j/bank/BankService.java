package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу простейшей банковской системы.
 * @author ZHAVORONKOV ALEXEY
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user пользователь который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * @param passport паспорт для поиска пользователя
     * @param account новый счет для добавления к пользователю
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport паспорт для поиска пользователя
     * @return возвращает найденного пользователя или null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * @param passport паспорт для поиска пользователя
     * @param requisite реквизит для нахождения нужного счета пользователя
     * @return возвращает найденный аккаунт или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(element -> element.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport паспорт для поиска аккаунта с которого переводят деньги
     * @param srcRequisite реквизиты для поиска аккаунта с которого переводят деньги
     * @param destPassport паспорт для поиска аккаунта куда переводят деньги
     * @param destRequisite реквизиты для поиска аккаунта куда переводят деньги
     * @param amount количество переводимых денег
     * @return возвращает true при удачном выполнении или false
     * если аккаунты не были найдены или сумма на счете меньше запрашиваемой
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            return true;
        }
        return false;
    }
}
