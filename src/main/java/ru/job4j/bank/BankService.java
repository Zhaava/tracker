package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (accounts != null) {
            for (Account element : accounts) {
                if (element.getRequisite().equals(requisite)) {
                    return element;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        int indexOfSrcAccount = users.get(srcUser).indexOf(new Account(srcRequisite, -1));
        int indexOfDestAccount = users.get(destUser).indexOf(new Account(destRequisite, -1));
        Account srcAccount = users.get(srcUser).get(indexOfSrcAccount);
        Account destAccount = users.get(srcUser).get(indexOfDestAccount);
        if (srcUser != null || destUser != null || srcAccount.getBalance() > amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }
}
