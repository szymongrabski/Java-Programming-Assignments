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
        System.out.println("2. Dodaj zadanie");
        System.out.println("3. Usuń spotkanie");
        System.out.println("4. Usuń zadanie");
        System.out.println("5. Wyświetl wszystkie spotkania z danego dnia");
        System.out.println("6. Wyświetl wszystkie zadania z danego dnia");
        System.out.println("7. Wyświetl wszystkie spotkania z danego dnia o danym priorytecie");
        System.out.println("8. Wyświetl wszystkie zadania z danego dnia o danym statusie");
        System.out.println("9. Wyświetl wszystkie spotkania z danego dnia zaczynających się nie wcześniej niż o podanej godzinie");
        System.out.println("10. Wyświetl wszystkie zadania z danego dnia o danym statusie i kończącym się nie później niż o podanej godzinie");
        System.out.println("11. Wyjdź z programu");
    }

    public static void dodajSiedemSpotkan() {
        int dzien = 1;
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(12, 30), LocalTime.of(19, 0), "normalny"));
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(15, 30), LocalTime.of(17, 0), "wysoki"));
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(13, 30), LocalTime.of(14, 0), "najwyższy"));
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(14, 30), LocalTime.of(19, 0), "normalny"));
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(18, 30), LocalTime.of(19, 0), "wysoki"));
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(13, 45), LocalTime.of(14, 0), "normalny"));
        kalendarz.dodajRzecz(dzien, new Spotkanie("Spotkanie", LocalTime.of(20, 30), LocalTime.of(21, 0), "normalny"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(19, 30), LocalTime.of(23, 0), "planowane"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(20, 30), LocalTime.of(21, 0), "potwierdzone"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(18, 30), LocalTime.of(19, 0), "realizowane"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(12, 30), LocalTime.of(14, 0), "realizowane"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(13, 30), LocalTime.of(15, 0), "planowany"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(10, 30), LocalTime.of(11, 0), "planowany"));
        kalendarz.dodajRzecz(dzien, new Zadanie("Zadanie", LocalTime.of(6, 30), LocalTime.of(22, 0), "planowany"));
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

    public static String wprowadzStatus() {
        String status;
        do {
            System.out.print("Podaj status zadania (planowane, potwierdzone, realizowane, wykonane): ");
            status = scanner.nextLine().toLowerCase();
            if (!status.equals("planowane") && !status.equals("potwierdzone") && !status.equals("realizowane") && !status.equals("wykonane")) {
                System.out.println("Nieprawidłowy status. Wprowadź planowane, potwierdzone, realizowane lub wykonane.");
            }
        } while (!status.equals("planowane") && !status.equals("potwierdzone") && !status.equals("realizowane") && !status.equals("wykonane"));
        return status;
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
        kalendarz.dodajRzecz(dzien, noweSpotkanie);

        System.out.println("Nowe spotkanie zostało dodane do kalendarza.");
    }

    public static void dodajZadanie() {
        int dzien = wprowadzDzien();
        String status = wprowadzStatus();
        String opis = wprowadzOpis();
        LocalTime czasPoczatku = wprowadzCzasPoczatku();
        LocalTime czasZakonczenia = wprowadzCzasZakonczenia(czasPoczatku);

        Zadanie noweZadanie = new Zadanie(opis, czasPoczatku, czasZakonczenia, status);
        kalendarz.dodajRzecz(dzien, noweZadanie);

        System.out.println("Nowe zadanie zostało dodane do kalendarza.");
    }

    public static void wyswietlRzeczy(ArrayList<Rzecz> rzeczy) {
        for (int i = 0; i < rzeczy.size(); i++) {
            Rzecz rzecz = rzeczy.get(i);
            System.out.println("Indeks " + (i) + ":");
            System.out.println(rzecz.toString());
        }
    }

    public static void usunSpotkanie() {
        int dzien = wprowadzDzien();
        ArrayList<Rzecz> spotkania = kalendarz.filtrujRzeczy(dzien, spotkanie -> spotkanie instanceof Spotkanie);
        if (spotkania.isEmpty()) {
            System.out.println("Brak spotkań do usunięcia.");
            return;
        }
        wyswietlRzeczy(spotkania);
        System.out.print("Podaj indeks spotkania do usunięcia: ");
        int indeks = scanner.nextInt();
        if (indeks < 0 || indeks >= spotkania.size()) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }
        int id = kalendarz.pobierzIdZKalendarza(dzien, spotkania.get(indeks));
        kalendarz.usunRzecz(dzien, id);
        System.out.println("Spotkanie zostało usunięte.");
    }

    public static void usunZadanie() {
        int dzien = wprowadzDzien();
        ArrayList<Rzecz> zadania = kalendarz.filtrujRzeczy(dzien, zadanie -> zadanie instanceof Zadanie);
        if (zadania.isEmpty()) {
            System.out.println("Brak zadań do usunięcia.");
            return;
        }
        wyswietlRzeczy(zadania);
        System.out.print("Podaj indeks zadania do usunięcia: ");
        int indeks = scanner.nextInt();
        if (indeks < 0 || indeks >= zadania.size()) {
            System.out.println("Nieprawidłowy indeks.");
            return;
        }
        int id = kalendarz.pobierzIdZKalendarza(dzien, zadania.get(indeks));
        kalendarz.usunRzecz(dzien, id);
        System.out.println("Zadanie zostało usunięte.");
    }

    public static void wyswietlSpotkaniaDanegoDnia() {
        int dzien = wprowadzDzien();
        Predicate<Rzecz> wszystkieSpotkania = spotkanie -> spotkanie instanceof Spotkanie;
        ArrayList<Rzecz> spotkania = kalendarz.filtrujRzeczy(dzien, wszystkieSpotkania);
        wyswietlRzeczy(spotkania);

    }
    public static void wyswietlZadaniaDanegoDnia() {
        int dzien = wprowadzDzien();
        Predicate<Rzecz> wszystkieZadania = zadanie -> zadanie instanceof Zadanie;
        ArrayList<Rzecz> zadania = kalendarz.filtrujRzeczy(dzien, wszystkieZadania);
        wyswietlRzeczy(zadania);
    }

    public static void wyswietlSpotkaniaDanegoDniaOPriorytecie() {
        int dzien = wprowadzDzien();
        String priorytet = wprowadzPriorytet();
        Predicate<Rzecz> pobierzSpotkaniaOPriorytecie = s -> s instanceof Spotkanie && ((Spotkanie) s).getPriorytet().equals(priorytet);
        ArrayList<Rzecz> spotkania = kalendarz.filtrujRzeczy(dzien, pobierzSpotkaniaOPriorytecie);
        wyswietlRzeczy(spotkania);
    }

    public static void wyswietlZadaniaDanegoDniaOStatusie() {
        int dzien = wprowadzDzien();
        String status = wprowadzStatus();
        Predicate<Rzecz> pobierzZadaniaOStatusie = z -> z instanceof Zadanie && ((Zadanie) z).getStatus().equals(status);
        ArrayList<Rzecz> zadania = kalendarz.filtrujRzeczy(dzien, pobierzZadaniaOStatusie);
        wyswietlRzeczy(zadania);
    }

    public static void wyswietlSpotkaniaDanegoDniaOPriorytecieNieWczesniejNiz() {
        int dzien = wprowadzDzien();
        LocalTime godzinaRozpoczecia = wprowadzCzas();
        String priorytet = wprowadzPriorytet();
        Predicate<Rzecz> spotkanieWPredzialeCzasowym = spotkanie -> spotkanie instanceof Spotkanie &&
                (spotkanie.getCzasPoczatku().equals(godzinaRozpoczecia) || spotkanie.getCzasPoczatku().isAfter(godzinaRozpoczecia)) &&
                        ((Spotkanie)spotkanie).getPriorytet().equals(priorytet);

        ArrayList<Rzecz> spotkania = kalendarz.filtrujRzeczy(dzien, spotkanieWPredzialeCzasowym);
        wyswietlRzeczy(spotkania);
    }

    public static void wyswietlZadaniaDanegoDniaOStatusieNiePozniejNiz() {
        int dzien = wprowadzDzien();
        LocalTime godzinaZakonczenia = wprowadzCzas();
        String status = wprowadzStatus();
        Predicate<Rzecz> zadanieWPredzialeCzasowym = z -> z instanceof Zadanie &&
                (z.getCzasZakonczenia().equals(godzinaZakonczenia) || z.getCzasZakonczenia().isBefore(godzinaZakonczenia)) &&
                ((Zadanie) z).getStatus().equals(status);

        ArrayList<Rzecz> spotkania = kalendarz.filtrujRzeczy(dzien, zadanieWPredzialeCzasowym);
        wyswietlRzeczy(spotkania);
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
                case 2 -> dodajZadanie();
                case 3 -> usunSpotkanie();
                case 4 -> usunZadanie();
                case 5 -> wyswietlSpotkaniaDanegoDnia();
                case 6 -> wyswietlZadaniaDanegoDnia();
                case 7 -> wyswietlSpotkaniaDanegoDniaOPriorytecie();
                case 8 -> wyswietlZadaniaDanegoDniaOStatusie();
                case 9 -> wyswietlSpotkaniaDanegoDniaOPriorytecieNieWczesniejNiz();
                case 10 -> wyswietlZadaniaDanegoDniaOStatusieNiePozniejNiz();
                case 11 -> works = false;
                default -> System.out.println("Nieprawidłowa opcja");
            }
        }
    }
}
