package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                rsl = users[index];
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User is not found in list");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() == false || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            System.out.println(ei);
        } catch (UserNotFoundException ef) {
            System.out.println(ef);
        }
    }
}
