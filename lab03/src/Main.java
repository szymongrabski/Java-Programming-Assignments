import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GradeList gradeList = new GradeList();
    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Dodaj ocene");
        System.out.println("2. Wyświetl średnią ocen");
        System.out.println("3. Wyświetl najwyższą ocene");
        System.out.println("4. Wyświetl najniższą ocene");
        System.out.println("5. Wyjdź z programu");
    }

    public static void addGrade() {
        System.out.print("Wprowadź ocene: ");
        double n = scanner.nextDouble();
        gradeList.addGrade(n);
    }

    public static void displayAverage() {
        if (gradeList.isEmpty()) System.out.println("Brak ocen");
        else System.out.println("Średnia ocen: " + gradeList.getAverageGrade());
    }

    public static void displayMin() {
        if (gradeList.isEmpty()) System.out.println("Brak ocen");
        else System.out.println("Najniższa ocena: " + gradeList.getMinGrade());
    }

    public static void displayMax() {
        if (gradeList.isEmpty()) System.out.println("Brak ocen");
        else System.out.println("Najwyższa ocena: " + gradeList.getMaxGrade());
    }

    public static void main(String[] args) {
        boolean works = true;
        displayMenu();
        while (works) {
            System.out.print("Wybierz opcję: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> addGrade();
                case 2 -> displayAverage();
                case 3 -> displayMax();
                case 4 -> displayMin();
                case 5 -> works = false;
                default -> System.out.println("Nieprawidłowa opcja");
            }
        }
    }
}
