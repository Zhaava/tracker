package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
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
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * @param passport паспорт для поиска пользователя
     * @param requisite реквизит для нахождения нужного счета пользователя
     * @return возвращает найденный аккаунт или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account element : accounts) {
                if (element.getRequisite().equals(requisite)) {
                    return element;
                }
            }
        }
        return null;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}
