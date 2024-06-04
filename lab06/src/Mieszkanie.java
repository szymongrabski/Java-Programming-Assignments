import java.time.LocalDate;
public final class Mieszkanie extends Nieruchomosc {
    private int numerMieszkania;
    private int numerPietra;
    public Mieszkanie(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double cena, LocalDate dataObowiazywania, int numerMieszkania, int numerPietra) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, cena, dataObowiazywania);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }

    public int getNumerPietra() {
        return numerPietra;
    }

    @Override
    public String toString() {
        return "Adres: " + numerMieszkania + '/' + numerDomu + " " + ulica + ", " + miejscowosc + ", " + kodPocztowy + "\n" +
                "Cena: " + cena + "\n" +
                "Data obowiązywania oferty: " + getDataObowiazywania() + "\n" +
                "Numer piętra: " + numerPietra;
    }
}
