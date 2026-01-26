package cinema;
public class Cassiere extends Persona {
    private double incasso = 0.0;

    public Cassiere(String nome, String cognome) {
        super(nome, cognome);
    }

    public void vendiBiglietto(Cliente cliente, Film film, int quantita) throws Exception {
        if (quantita <= 0) {
            throw new Exception("La quantità del biglietto deve essere almeno uno");
        }

        cliente.aggiungiBiglietto(film, quantita);

        for (int i = 0; i < quantita; i++) {
            incasso += film.getCostoBiglietto();
        }
    }

    public double getIncasso() {
        return incasso;
    }
}
