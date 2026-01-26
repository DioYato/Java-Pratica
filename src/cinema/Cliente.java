package cinema;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Film> biglietti = new ArrayList<>();

    public Cliente(String nome, String cognome) {
        super(nome, cognome);
    }

    public void aggiungiBiglietto(Film film, int quantita) throws Exception {
        if (quantita <= 0) {
            throw new Exception("La quantità del biglietto deve essere almeno uno");
        }

        film.sottraiPosti(quantita);

        for (int i = 0; i < quantita; i++) {
            biglietti.add(film);
        }
    }
}
