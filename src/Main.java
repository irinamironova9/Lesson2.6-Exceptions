public class Main {
    public static void main(String[] args) throws WrongLoginException,
            WrongPasswordException {

        System.out.println(Data.isCorrect("login_4", "pass_02", "pass_02"));
        System.out.println(Data.isCorrect("login_4", "pass_02", "pass_03"));

    }
}