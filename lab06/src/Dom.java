import java.time.LocalDate;

public final class Dom extends Nieruchomosc {
    private double powierzchnia;

    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double cena, LocalDate dataObowiazywania, double powierzchnia) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, cena, dataObowiazywania);
        this.powierzchnia = powierzchnia;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }


    @Override
    public String toString() {
        return "Adres: " + numerDomu + " " + ulica + ", " + miejscowosc + ", " + kodPocztowy + "\n" +
                "Cena: " + cena + "\n" +
                "Data obowiązywania oferty: " + dataObowiazywania + "\n" +
                "Powierzchnia: " + powierzchnia;
    }
}
