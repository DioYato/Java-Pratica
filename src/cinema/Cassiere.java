package cinema;

public class Cassiere extends persona {

    private double incasso = 0;

    public Cassiere(String nome) {
        super(nome);
    }

    public void aggiungiIncasso(double importo) {
        incasso += importo;
    }

    public double getIncasso() {
        return incasso;
    }

    @Override
    public void ruolo() {
        System.out.println("Sono un cassiere");
    }
    
    public boolean vendiBiglietti(Cliente cliente, Film film, int quantita) {
        if (film.vendiBiglietto(quantita)) {
            double totale = film.getPrezzoBiglietto() * quantita;
            aggiungiIncasso(totale);
            System.out.println(cliente.getNome() + " ha acquistato " + quantita + " biglietti per " + film.getTitolo());
            return true;
        } else {
            System.out.println("Posti insufficienti per il film: " + film.getTitolo());
            return false;
        }
    }

}



