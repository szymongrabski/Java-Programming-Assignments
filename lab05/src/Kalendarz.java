import java.util.*;
import java.util.function.Predicate;

public class Kalendarz {
    private Map<Integer, ArrayList<Rzecz>> dniTygodnia;

    public Kalendarz() {
        dniTygodnia = new HashMap<>();
        dniTygodnia.put(1, new ArrayList<>());
        dniTygodnia.put(2, new ArrayList<>());
        dniTygodnia.put(3, new ArrayList<>());
        dniTygodnia.put(4, new ArrayList<>());
        dniTygodnia.put(5, new ArrayList<>());
    }

    public void dodajRzecz(int dzien, Rzecz rzecz) {
        ArrayList<Rzecz> rzeczyDlaDanegoDnia = dniTygodnia.get(dzien);
        rzeczyDlaDanegoDnia.add(rzecz);
    }

    public void usunRzecz(int dzien, int indeks) {
        ArrayList<Rzecz> rzeczyDlaDanegoDnia = dniTygodnia.get(dzien);
        rzeczyDlaDanegoDnia.remove(indeks);
    }

    public int pobierzIdZKalendarza(int dzien, Rzecz rzecz) {
        ArrayList<Rzecz> rzeczyZDanegoDnia = dniTygodnia.get(dzien);
        if (rzeczyZDanegoDnia != null) {
            for (int i = 0; i < rzeczyZDanegoDnia.size(); i++) {
                if (rzeczyZDanegoDnia.get(i).equals(rzecz)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public ArrayList<Rzecz> filtrujRzeczy(int dzien, Predicate<Rzecz> warunek) {
        ArrayList<Rzecz> rzeczyZDanegoDnia = dniTygodnia.getOrDefault(dzien, new ArrayList<>());
        ArrayList<Rzecz> rzeczyPoFiltrze = new ArrayList<>();

        for (Rzecz rzecz : rzeczyZDanegoDnia) {
            if (warunek.test(rzecz)) {
                rzeczyPoFiltrze.add(rzecz);
            }
        }
        return rzeczyPoFiltrze;
    }
}
