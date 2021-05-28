import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String s = scanner.nextLine();
        Parser parser = new Parser();
        parser.match(s);
    }
}

