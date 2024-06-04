import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Wyświetl wysokość i promień podstawy walca");
        System.out.println("2. Ustaw wysokość walca i promień podstawy");
        System.out.println("3. Wyświetl pola walca");
        System.out.println("4. Wyświetl objętość walca");
        System.out.println("5. Wyjdź z programu");
        System.out.print("Wybierz opcję: ");
    }

    public static void displayAreas(Walec walec) {
        double polePodstawy = walec.obliczPolePodstawy();
        System.out.println("Pole powierzchni podstawy wynosi: " + polePodstawy);
        double poleBoczne = walec.obliczPoleBoczne();
        System.out.println("Pole powierzchni bocznej wynosi: " + poleBoczne);
        double poleCalkowite = walec.obliczPoleCalkowite();
        System.out.println("Pole powierzchni całkowitej wynosi: " + poleCalkowite);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Walec walec = new Walec();
        boolean works = true;
        displayMenu();
        while (works) {
            System.out.print("Wybierz opcję: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Wysokość walca: " + walec.getWysokosc() + ", Pole powierzchni podstawy: " + walec.getPromienPodstawy());
                }
                case 2 -> {
                    System.out.print("Wprowadź wysokość: ");
                    double h = scanner.nextDouble();
                    walec.setWysokosc(h);
                    System.out.print("Wprowadź promień podstawy: ");
                    double r = scanner.nextDouble();
                    walec.setPromienPodstawy(r);
                }
                case 3 -> displayAreas(walec);
                case 4 -> System.out.println("Objętość wynosi: " + walec.obliczObjetosc());
                case 5 -> works = false;
                default -> System.out.println("Nieprawidłowa opcja");
            }
        }
    }
}
