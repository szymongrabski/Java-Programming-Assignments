import java.time.LocalTime;

sealed abstract class Rzecz permits Spotkanie, Zadanie {

    protected static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(12, 0);
    protected String opis;
    protected LocalTime czasPoczatku;
    protected LocalTime czasZakonczenia;

    public Rzecz(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
    }

    public static LocalTime getNajwczesniejszaGodzina() {
        return NAJWCZESNIEJSZA_GODZINA;
    }

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }
}
