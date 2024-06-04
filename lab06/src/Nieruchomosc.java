import java.time.LocalDate;
sealed abstract class Nieruchomosc permits Dom, Mieszkanie {
    protected String ulica;
    protected int numerDomu;

    protected String miejscowosc;
    protected String kodPocztowy;
    protected double cena;

    protected LocalDate dataObowiazywania;

    public Nieruchomosc(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double cena, LocalDate dataObowiazywania) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.cena = cena;
        this.dataObowiazywania = dataObowiazywania;
    }

    public LocalDate getDataObowiazywania() {
        return dataObowiazywania;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public double getCena() {
        return cena;
    }
}
