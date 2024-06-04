public class Walec {
    private double promienPodstawy;
    private double wysokosc;

    public Walec(double promienPodstawy, double wysokosc) {
        setPromienPodstawy(promienPodstawy);
        setWysokosc(wysokosc);
    }

    public Walec() {}

    public void setPromienPodstawy(double promienPodstawy) {
        if (promienPodstawy > 0) {
            this.promienPodstawy = promienPodstawy;
        }
    }

    public double getPromienPodstawy() {
        return promienPodstawy;
    }

    public void setWysokosc(double wysokosc) {
        if (wysokosc > 0) {
            this.wysokosc = wysokosc;
        }
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double obliczPolePodstawy() {
        return Math.PI * Math.pow(promienPodstawy, 2);
    }

    public double obliczPoleBoczne() {
        return 2 * Math.PI * promienPodstawy * wysokosc;
    }

    public double obliczPoleCalkowite() {
        double polePodstawy = obliczPolePodstawy();
        double poleBoczne = obliczPoleBoczne();
        return 2 * polePodstawy + poleBoczne;
    }

    public double obliczObjetosc() {
        double polePodstawy = obliczPolePodstawy();
        return polePodstawy * wysokosc;
    }
}
