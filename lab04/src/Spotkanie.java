import java.time.LocalTime;

public class Spotkanie {
    private static final LocalTime NAJWCZESNIEJSZA_GODZINA = LocalTime.of(12, 0);
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private String priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = priorytet;
    }

    @Override
    public String toString() {
        return opis + "\nOd " + czasPoczatku + " do " + czasZakonczenia + "\nPriorytet: " + priorytet + "\n";
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

    public String getPriorytet() {
        return priorytet;
    }

    public static LocalTime getNajwczesniejszaGodzina() {
        return NAJWCZESNIEJSZA_GODZINA;
    }
}
