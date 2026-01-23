package cinema;

public class Film {

    private String titolo;
    private int postiDisponibili;
    private double prezzoBiglietto;

    public Film(String titolo, int postiDisponibili, double prezzoBiglietto) {
        this.titolo = titolo;
        this.postiDisponibili = postiDisponibili;
        this.prezzoBiglietto = prezzoBiglietto;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public double getPrezzoBiglietto() {
        return prezzoBiglietto;
    }

    public boolean vendiBiglietto(int quantita) {
        if (quantita <= postiDisponibili) {
            postiDisponibili -= quantita;
            return true;
        }
        return false;
    }
}
