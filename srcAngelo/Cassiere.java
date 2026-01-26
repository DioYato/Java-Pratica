import java.util.ArrayList;

public class Cassiere extends Persona {

    public Cassiere (String nome, String cognome, int postoAssegnato) {
        super(nome,cognome,postoAssegnato);
    }

    //riceve come parametro richiesta dal cliente, riceve dal manager e dà al cliente
    public void vende(String richiesta, Manager manager, Cliente cliente) {
        Films biglietto = manager.vendiBiglietto(richiesta, cliente);

        if (biglietto != null) {
            System.out.println("Biglietto per " + biglietto.getTitolo() +
                    " acquistato con successo, posto assegnato: " + biglietto.getPosto());
        } else {
            System.out.println("Film non disponibile o esaurito");
        }
    }

}
