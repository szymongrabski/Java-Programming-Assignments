import java.time.LocalTime;

public final class Spotkanie extends Rzecz {
    private String priorytet;
    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.priorytet = priorytet;
    }

    @Override
    public String toString() {
        return opis + "\nOd " + czasPoczatku + " do " + czasZakonczenia + "\nPriorytet: " + priorytet + "\n";
    }

    public String getPriorytet() {
        return priorytet;
    }
}
