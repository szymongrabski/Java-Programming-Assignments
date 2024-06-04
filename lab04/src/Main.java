import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.function.Predicate;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Kalendarz kalendarz = new Kalendarz();

    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Dodaj spotkanie");
        System.out.println("2. Usuń spotkanie");
        System.out.println("3. Wyświetl wszystkie spotkania z danego dnia");
        System.out.println("4. Wyświetl wszystkie spotkania z danego dnia o danym priorytecie");
        System.out.println("5. Wyświetl wszystkie spotkania z danego dnia zaczynających się nie wcześniej niż o podanej godzinie");
        System.out.println("6. Wyświetl wszystkie spotkania z danego dnia w danym przedziale czasowym");
        System.out.println("7. Wyświetl wszystkie spotkania z danego dnia o danym priorytecie nie wcześniej niż o podanej godzinie");
        System.out.println("8. Wyjdź z programu");
    }

    public static void dodajSiedemSpotkan() {
        int dzien = 1;
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(12, 30), LocalTime.of(19, 0), "normalny"));
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(15, 30), LocalTime.of(17, 0), "wysoki"));
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(13, 30), LocalTime.of(14, 0), "najwyższy"));
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(14, 30), LocalTime.of(19, 0), "normalny"));
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(18, 30), LocalTime.of(19, 0), "wysoki"));
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(13, 45), LocalTime.of(14, 0), "normalny"));
        kalendarz.dodajSpotkanie(dzien, new Spotkanie("Spotkanie", LocalTime.of(20, 30), LocalTime.of(21, 0), "normalny"));
    }

    public static int wprowadzDzien() {
        int dzien;
        do {
            System.out.print("Podaj dzień spotkania (od 1 do 5, gdzie 1 to poniedziałek, a 5 to piątek): ");
            dzien = scanner.nextInt();
            if (dzien < 1 || dzien > 5) {
                System.out.println("Nieprawidłowy dzień. Wprowadź wartość od 1 do 5.");
            }
        } while (dzien < 1 || dzien > 5);
        scanner.nextLine();
        return dzien;
    }
    public static String wprowadzOpis() {
        System.out.println("Podaj krótki opis spotkania: ");
        return scanner.nextLine();
    }

    public static String wprowadzPriorytet() {
        String priorytet;
        do {
            System.out.print("Podaj priorytet spotkania (normalny, wysoki, najwyższy): ");
            priorytet = scanner.nextLine().toLowerCase();
            if (!priorytet.equals("normalny") && !priorytet.equals("wysoki") && !priorytet.equals("najwyższy")) {
                System.out.println("Nieprawidłowy priorytet. Wprowadź normalny, wysoki lub najwyższy.");
            }
        } while (!priorytet.equals("normalny") && !priorytet.equals("wysoki") && !priorytet.equals("najwyższy"));
        return priorytet;
    }
    public static LocalTime wprowadzCzasPoczatku() {
        LocalTime czasPoczatku;
        do {
            System.out.print("Podaj godzinę rozpoczęcia spotkania (w formacie hh:mm): ");
            String input = scanner.nextLine();
            try {
                czasPoczatku = LocalTime.parse(input);
                if (czasPoczatku.isBefore(Spotkanie.getNajwczesniejszaGodzina())) {
                    System.out.println("Godzina rozpoczęcia nie może być wcześniejsza niż najwcześniejsza godzina (" + Spotkanie.getNajwczesniejszaGodzina() + ").");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Nieprawidłowy format godziny. Wprowadź godzinę w formacie hh:mm.");
            }
        } while (true);
        return czasPoczatku;
    }

    public static LocalTime wprowadzCzasZakonczenia(LocalTime czasRozpoczecia) {
        LocalTime czasZakonczenia;
        do {
            System.out.print("Podaj godzinę zakończenia spotkania (w formacie hh:mm): ");
            String input = scanner.nextLine();
            try {
                czasZakonczenia = LocalTime.parse(input);
                if (czasZakonczenia.isBefore(czasRozpoczecia)) {
                    System.out.println("Czas zakończenia nie może być wcześniejszy niż czas rozpoczęcia (" + czasRozpoczecia + ").");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Nieprawidłowy format godziny. Wprowadź godzinę w formacie hh:mm.");
            }
        } while (true);
        return czasZakonczenia;
    }

    public static LocalTime wprowadzCzas() {
        System.out.print("Podaj czas (w formacie hh:mm): ");
        String input = scanner.nextLine();
        LocalTime czas = LocalTime.parse(input);
        return czas;
    }

    public static void dodajSpotkanie() {
        int dzien = wprowadzDzien();
        String priorytet = wprowadzPriorytet();
        String opis = wprowadzOpis();
        LocalTime czasPoczatku = wprowadzCzasPoczatku();
        LocalTime czasZakonczenia = wprowadzCzasZakonczenia(czasPoczatku);

        Spotkanie noweSpotkanie = new Spotkanie(opis, czasPoczatku, czasZakonczenia, priorytet);
        kalendarz.dodajSpotkanie(dzien, noweSpotkanie);

        System.out.println("Nowe spotkanie zostało dodane do kalendarza.");
    }

    public static void wyswietlSpotkania(ArrayList<Spotkanie> spotkania) {
        System.out.println("Spotkania w danym dniu:\n");
        for (int i = 0; i < spotkania.size(); i++) {
            Spotkanie spotkanie = spotkania.get(i);
            System.out.println("Indeks " + (i) + ":");
            System.out.println(spotkanie.toString());
        }
    }
    public static void usunSpotkanie() {
        int dzien = wprowadzDzien();
        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, spotkanie -> true);
        if (spotkania.isEmpty()) {
            System.out.println("Brak spotkań do usunięcia.");
            return;
        }
        wyswietlSpotkania(spotkania);
        System.out.print("Podaj indeks spotkania do usunięcia: ");
        int indeks = scanner.nextInt();
        if (indeks < 0 || indeks >= spotkania.size()) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }
        kalendarz.usunSpotkanie(dzien, indeks);
        System.out.println("Spotkanie zostało usunięte.");
    }

    public static void wyswietlSpotkaniaDanegoDnia() {
        int dzien = wprowadzDzien();
        Predicate<Spotkanie> wszystkieSpotkania = spotkanie -> true;
        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, wszystkieSpotkania);
        wyswietlSpotkania(spotkania);
    }
    public static void wyswietlSpotkaniaDanegoDniaOPriorytecie() {
        int dzien = wprowadzDzien();
        String priorytet = wprowadzPriorytet();
        Predicate<Spotkanie> pobierzSpotkaniaOPriorytecie = spotkanie -> spotkanie.getPriorytet().equals(priorytet);
        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, pobierzSpotkaniaOPriorytecie);
        wyswietlSpotkania(spotkania);
    }

    public static void wyswietlSpotkaniaDanegoDniaNieWczesniejNiz() {
        int dzien = wprowadzDzien();
        LocalTime godzina = wprowadzCzas();
        Predicate<Spotkanie> spotkaniePoOkreslonejGodzinie = spotkanie -> !spotkanie.getCzasPoczatku().isBefore(godzina);
        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, spotkaniePoOkreslonejGodzinie);
        wyswietlSpotkania(spotkania);
    }

    public static void wyswietlSpotkaniaDanegoDniaWPrzedzialeCzasowym() {
        int dzien = wprowadzDzien();
        System.out.print("Rozpoczęcia: ");
        LocalTime godzinaRozpoczecia = wprowadzCzas();
        System.out.println("Zakończenia: ");
        LocalTime godzinaZakonczenia = wprowadzCzas();

        Predicate<Spotkanie> spotkanieWPredzialeCzasowym = spotkanie ->
                (spotkanie.getCzasPoczatku().equals(godzinaRozpoczecia) || spotkanie.getCzasPoczatku().isAfter(godzinaRozpoczecia)) &&
                        (spotkanie.getCzasZakonczenia().equals(godzinaZakonczenia) || spotkanie.getCzasZakonczenia().isBefore(godzinaZakonczenia));

        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, spotkanieWPredzialeCzasowym);
        wyswietlSpotkania(spotkania);
    }

    public static void wyswietlSpotkaniaDanegoDniaOPriorytecieNieWczesniejNiz() {
        int dzien = wprowadzDzien();
        LocalTime godzinaRozpoczecia = wprowadzCzas();
        String priorytet = wprowadzPriorytet();
        Predicate<Spotkanie> spotkanieWPredzialeCzasowym = spotkanie ->
                (spotkanie.getCzasPoczatku().equals(godzinaRozpoczecia) || spotkanie.getCzasPoczatku().isAfter(godzinaRozpoczecia)) &&
                        (spotkanie.getPriorytet().equals(priorytet));

        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, spotkanieWPredzialeCzasowym);
        wyswietlSpotkania(spotkania);
    }

    public static void main(String[] args) {
        dodajSiedemSpotkan();
        boolean works = true;
        while (works) {
            displayMenu();
            System.out.print("Wybierz opcję: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> dodajSpotkanie();
                case 2 -> usunSpotkanie();
                case 3 -> wyswietlSpotkaniaDanegoDnia();
                case 4 -> wyswietlSpotkaniaDanegoDniaOPriorytecie();
                case 5 -> wyswietlSpotkaniaDanegoDniaNieWczesniejNiz();
                case 6 -> wyswietlSpotkaniaDanegoDniaWPrzedzialeCzasowym();
                case 7 -> wyswietlSpotkaniaDanegoDniaOPriorytecieNieWczesniejNiz();
                case 8 -> works = false;
                default -> System.out.println("Nieprawidłowa opcja");
            }
        }
    }
}
