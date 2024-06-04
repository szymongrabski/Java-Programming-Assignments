import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//local time, local date(przypomnij, niezmienne) przeciazanie metod ( ze zlymi parametrami), zastosowanie operatora rzutowanie, klasy abstrakcyjne, implementacja interfejsu, wyrażenia lambda, interfejs predicate
public class Kalendarz {
    private Map<Integer, ArrayList<Spotkanie>> dniTygodnia;

    public Kalendarz() {
        dniTygodnia = new HashMap<>();
        dniTygodnia.put(1, new ArrayList<>());
        dniTygodnia.put(2, new ArrayList<>());
        dniTygodnia.put(3, new ArrayList<>());
        dniTygodnia.put(4, new ArrayList<>());
        dniTygodnia.put(5, new ArrayList<>());
    }

    public void dodajSpotkanie(int dzien, Spotkanie spotkanie) {
        ArrayList<Spotkanie> spotkaniaDlaDanegoDnia = dniTygodnia.get(dzien);
        spotkaniaDlaDanegoDnia.add(spotkanie);
    }

    public void usunSpotkanie(int dzien, int indeks) {
        ArrayList<Spotkanie> spotkaniaDlaDanegoDnia = dniTygodnia.get(dzien);
        spotkaniaDlaDanegoDnia.remove(indeks);
    }

    public ArrayList<Spotkanie> filtrujSpotkania(int dzien, Predicate<Spotkanie> warunek) {
        ArrayList<Spotkanie> spotkaniaZDanegoDnia = dniTygodnia.getOrDefault(dzien, new ArrayList<>());
        ArrayList<Spotkanie> spotkaniaPoFiltrze = new ArrayList<>();

        for (Spotkanie spotkanie : spotkaniaZDanegoDnia) {
            if (warunek.test(spotkanie)) {
                spotkaniaPoFiltrze.add(spotkanie);
            }
        }
        return spotkaniaPoFiltrze;
    }
}
