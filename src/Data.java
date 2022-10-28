public class Data {
    public static boolean isCorrect(String login,
                                    String password,
                                    String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (!isLengthCorrect(login) || !isContentCorrect(login)) {
            throw new WrongLoginException("Логин может содержать только буквы " +
                    "латинского алфавита, цифры и символ нижнего подчёркивания " +
                    "и быть не длинее 20 символов.");
        }

        if (!isLengthCorrect(password) || !isContentCorrect(password)) {
            throw new WrongPasswordException("Пароль может содержать только буквы " +
                    "латинского алфавита, цифры и символ нижнего подчёркивания " +
                    "и быть не длинее 20 символов.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }

        return true;
    }

    private static boolean isLengthCorrect(String value) {
        return value != null &&
                !value.isEmpty() &&
                !value.isBlank() &&
                value.length() <= 20;
    }

    private static boolean isContentCorrect(String value) {
        for (char c : value.toCharArray()) {
            boolean b = (c >= 'a' && c <= 'z') ||
                    (c >= 'A' && c <= 'Z') ||
                    Character.isDigit(c) ||
                    c == '_';
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
