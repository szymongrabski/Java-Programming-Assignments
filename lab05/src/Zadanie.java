import java.time.LocalTime;

public final class Zadanie extends Rzecz {
    private String status;
    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String status) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.status = status;
    }

    @Override
    public String toString() {
        return opis + "\nOd " + czasPoczatku + " do " + czasZakonczenia + "\nStauts: " + status + "\n";
    }
    public String getStatus() {
        return status;
    }
}
