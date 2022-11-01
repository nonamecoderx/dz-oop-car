package exeptions;

public class Data {

    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDIFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginExeption | WrongPasswordExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void check(String login, String password, String confirmPassword) throws WrongLoginExeption, WrongPasswordExeption {
        if (!validate(login)) {
            throw new WrongLoginExeption("Неверный логин");
        }
        if (!validate(password)) {
            throw new WrongPasswordExeption("Неверный пароль");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordExeption("Пароли должны  совпадать");
        }
    }

    private static boolean validate(String s) {
        if (s.length() > 20) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
