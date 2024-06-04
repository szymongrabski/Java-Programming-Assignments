import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Program obliczający: %n  1. Silnia %n  2. Suma z zakresu (a, b) %n  3. Zakończenie programu %n");
        boolean works = true;

        while (works) {
            System.out.print("Wybierz opcję: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Wprowadź n: ");
                    int n = scanner.nextInt();
                    int result = Obliczenia.factorial(n);
                    System.out.printf("Silnia z %d wynosi %d%n", n, result);
                }
                case 2 -> {
                    System.out.print("Wprowadź a: ");
                    int a = scanner.nextInt();
                    System.out.print("Wprowadź b: ");
                    int b = scanner.nextInt();
                    int result = Obliczenia.sum(a, b);
                    System.out.printf("Suma z zakresu (%d, %d) wynosi %d%n", a, b, result);
                }

                case 3 -> {
                    works = false;
                }
                default -> {
                    System.out.println("Nieprawidłowa opcja");
                }
            }
        }
    }
}