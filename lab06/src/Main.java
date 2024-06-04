import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ListaOfert listaOfert = new ListaOfert();

    public static void dodajOferty() {
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Kwiatowa", 10, "Miastowo", "12-345", 150000.0, LocalDate.of(2024, 5, 30), 1, 2));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Słoneczna", 20, "Wioski", "67-890", 200000.0, LocalDate.of(2024, 6, 15), 2, 3));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Leśna", 30, "Góry", "98-765", 180000.0, LocalDate.of(2024, 6, 20), 3, 1));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Słoneczna", 23, "Wioski", "67-890", 100000.0, LocalDate.of(2024, 6, 20), 2, 2));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Leśna", 31, "Góry", "98-765", 160000.0, LocalDate.of(2024, 10, 20), 3, 2));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Słoneczna", 22, "Wioski", "67-890", 200000.0, LocalDate.of(2025, 7, 15), 2, 4));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Leśna", 34, "Góry", "98-765", 150000.0, LocalDate.of(2024, 10, 23), 3, 5));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Słoneczna", 19, "Wioski", "67-890", 90000.0, LocalDate.of(2024, 6, 15), 2, 3));
        listaOfert.dodajNieruchomosc(new Mieszkanie("Ul. Leśna", 10, "Góry", "98-765", 100000.0, LocalDate.of(2024, 6, 20), 3, 7));

        listaOfert.dodajNieruchomosc(new Dom("Ul. Polna", 5, "Polanka", "54-321", 300000.0, LocalDate.of(2024, 6, 10), 150.0));
        listaOfert.dodajNieruchomosc(new Dom("Ul. Parkowa", 15, "Miasteczko", "78-901", 250000.0, LocalDate.of(2024, 6, 25), 120.0));
        listaOfert.dodajNieruchomosc(new Dom("Ul. Zaciszna", 25, "Nadjeziorne", "23-456", 280000.0, LocalDate.of(2024, 6, 30), 130.0));
        listaOfert.dodajNieruchomosc(new Dom("Ul. Osiedlowa", 35, "Podlasie", "67-890", 320000.0, LocalDate.of(2024, 7, 5), 160.0));
        listaOfert.dodajNieruchomosc(new Dom("Ul. Rozdarta", 26, "Nadjeziorne", "23-456", 500000.0, LocalDate.of(2024, 12, 30), 200.0));
        listaOfert.dodajNieruchomosc(new Dom("Ul. Zasiedlona", 31, "Podlasie", "67-890", 160000.0, LocalDate.of(2024, 10, 2), 100.0));
    }
    public static String wprowadzString(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    public static LocalDate wprowadzDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("Podaj datę obowiązywania ogłoszenia (w formacie yyyy-MM-dd): ");
            String input = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(input, dateFormatter);
                return localDate;
            } catch (DateTimeParseException e) {
                System.out.println("Błędny format daty. Spróbuj ponownie.");
            }
        }
    }

    public static int wprowadzInt(String text) {
        System.out.println(text);
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    public static double wprowadzDouble(String text) {
        System.out.println(text);
        double result = scanner.nextDouble();
        scanner.nextLine();
        return result;
    }

    public static void wyswietlNieruchomosci(ArrayList<Nieruchomosc> nieruchomosci) {
        for (int i = 0; i < nieruchomosci.size(); i++) {
            Nieruchomosc nieruchomosc = nieruchomosci.get(i);
            System.out.println(nieruchomosc.toString());
            System.out.println();
        }
    }

    public static void dodajDom() {
        String ulica = wprowadzString("Podaj ulicę: ");
        int numerDomu = wprowadzInt("Podaj numer domu: ");
        String miejscowosc = wprowadzString("Podaj miejscowość: ");
        String kodPocztowy = wprowadzString("Podaj kod pocztowy: ");
        double cena = wprowadzDouble("Podaj cenę: ");
        LocalDate dataObowiazywania = wprowadzDate();
        double powierzchnia = wprowadzDouble("Podaj powierzchnię: ");

        Dom dom = new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, cena, dataObowiazywania, powierzchnia);
        listaOfert.dodajNieruchomosc(dom);

        System.out.println("Oferta domu została dodana.");
    }
    public static void dodajMieszkanie() {
        String ulica = wprowadzString("Podaj ulicę: ");
        int numerDomu = wprowadzInt("Podaj numer domu: ");
        String miejscowosc = wprowadzString("Podaj miejscowość: ");
        String kodPocztowy = wprowadzString("Podaj kod pocztowy: ");
        double cena = wprowadzDouble("Podaj cenę: ");
        LocalDate dataObowiazywania = wprowadzDate();
        int numerMieszkania = wprowadzInt("Podaj numer mieszkania: ");
        int numerPietra = wprowadzInt("Podaj numer piętra: ");

        Mieszkanie mieszkanie = new Mieszkanie(ulica, numerDomu, miejscowosc, kodPocztowy, cena, dataObowiazywania, numerMieszkania, numerPietra);
        listaOfert.dodajNieruchomosc(mieszkanie);

        System.out.println("Oferta mieszkania została dodana.");
    }


    public static void wyswietlAktualneOferty(String typNieruchomosci) {
        Predicate<Nieruchomosc> warunek = nieruchomosc -> {
            boolean czyPasuje = false;
            if (typNieruchomosci.equals("Dom")) {
                czyPasuje = nieruchomosc instanceof Dom;
            } else if (typNieruchomosci.equals("Mieszkanie")) {
                czyPasuje = nieruchomosc instanceof Mieszkanie;
            }
            return czyPasuje && !nieruchomosc.getDataObowiazywania().isBefore(LocalDate.now());
        };
        ArrayList<Nieruchomosc> wynik = listaOfert.filtrujNieruchomosci(warunek);
        if (wynik.isEmpty()) {
            System.out.println("Brak aktualnych ofert " + typNieruchomosci.toLowerCase() + "ów.");
        } else {
            System.out.println("Aktualne oferty " + typNieruchomosci.toLowerCase() + "ów:");
            wyswietlNieruchomosci(wynik);
        }
    }

    public static void wyswietlDomy5() {
        LocalDate dzisiaj = LocalDate.now();
        String miejscowosc = wprowadzString("Podaj miejscowość: ");
        double minimalnaPowierzchnia = wprowadzDouble("Podaj powierzchnie");
        Predicate<Nieruchomosc> warunek = nieruchomosc ->
                nieruchomosc instanceof Dom &&
                        nieruchomosc.getMiejscowosc().equalsIgnoreCase(miejscowosc) &&
                        ((Dom) nieruchomosc).getPowierzchnia() >= minimalnaPowierzchnia &&
                        !nieruchomosc.getDataObowiazywania().isBefore(dzisiaj);

        ArrayList<Nieruchomosc> wynik = listaOfert.filtrujNieruchomosci(warunek);
        if (wynik.isEmpty()) {
            System.out.println("Brak aktualnych ofert domów w miejscowości " + miejscowosc + " o powierzchni co najmniej " + minimalnaPowierzchnia + " m^2.");
        } else {
            System.out.println("Aktualne oferty domów w miejscowości " + miejscowosc + " o powierzchni co najmniej " + minimalnaPowierzchnia + " m^2:");
            wyswietlNieruchomosci(wynik);
        }
    }

    public static void wyswietlMieszkania6() {
        String miejscowosc = wprowadzString("Podaj miejscowość: ");
        double maksymalnaCena = wprowadzDouble("Podaj cene minimalną: ");
        int minimalnePietro = wprowadzInt("Podaj minimalne piętro: ");
        Predicate<Nieruchomosc> warunek = nieruchomosc ->
                nieruchomosc instanceof Mieszkanie &&
                        nieruchomosc.getMiejscowosc().equalsIgnoreCase(miejscowosc) &&
                        nieruchomosc.getCena() <= maksymalnaCena &&
                        ((Mieszkanie) nieruchomosc).getNumerPietra() >= minimalnePietro &&
                        !nieruchomosc.getDataObowiazywania().isBefore(LocalDate.now());
        ArrayList<Nieruchomosc> wynik = listaOfert.filtrujNieruchomosci(warunek);
        if (wynik.isEmpty()) {
            System.out.println("Brak aktualnych ofert mieszkań w miejscowości " + miejscowosc + " o cenie nie większej niż " + maksymalnaCena + " i znajdujących się od piętra " + minimalnePietro + " wzwyż.");
        } else {
            System.out.println("Aktualne oferty mieszkań w miejscowości " + miejscowosc + " o cenie nie większej niż " + maksymalnaCena + " i znajdujących się od piętra " + minimalnePietro + " wzwyż:");
            wyswietlNieruchomosci(wynik);
        }
    }

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Dodaj oferte domu");
        System.out.println("2. Dodaj oferte mieszkania");
        System.out.println("3. Wyświetl aktualne oferty sprzedaży domów");
        System.out.println("4. Wyświetl aktualne oferty sprzedaży mieszkań");
        System.out.println("5. Wyświetl aktualne oferty domów, w podanej miejscowości o powierzchni nie mniejszej niż podana");
        System.out.println("6. Wyświetl aktualne oferty mieszkań, w podanej miejscowości nie droższych niż podana wartość i od podanego piętra wzwyż");
        System.out.println("7. Wyjdz z programu");
    }

    public static void main(String[] args) {
        boolean works = true;
        dodajOferty();
        while (works) {
            displayMenu();
            System.out.print("Wybierz opcję: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> dodajDom();
                case 2 -> dodajMieszkanie();
                case 3 -> wyswietlAktualneOferty("Dom");
                case 4 -> wyswietlAktualneOferty("Mieszkanie");
                case 5 -> wyswietlDomy5();
                case 6 -> wyswietlMieszkania6();
                case 7 -> works = false;
                default -> System.out.println("Nieprawidłowa opcja");
            }
        }
    }
}