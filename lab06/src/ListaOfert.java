import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {
    private ArrayList<Nieruchomosc> listaOfert = new ArrayList<>();

    public void dodajNieruchomosc(Nieruchomosc nieruchomosc) {
        listaOfert.add(nieruchomosc);
    }

    public ArrayList<Nieruchomosc> filtrujNieruchomosci(Predicate<Nieruchomosc> warunek) {
        ArrayList<Nieruchomosc> wynik = new ArrayList<>();

        for(Nieruchomosc nieruchomosc : listaOfert ) {
            if(warunek.test(nieruchomosc)) {
                wynik.add(nieruchomosc);
            }
        }
        return wynik;
    }
}
