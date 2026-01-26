import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Manager extends Persona{

    public Manager (String nome, String cognome, int postoAssegnato) {
        super(nome,cognome,postoAssegnato);
    }

    ArrayList<Films> biglietti = new ArrayList();
    ArrayList <Films> biglietti_acquistati = new ArrayList();



    {

        Films biglietto1 = new Films("Demon Slayer", 6, "B");
        Films biglietto2 = new Films("Jujutsu Kaisen", 7, "A");
        Films biglietto3 = new Films("One Piece", 5, "C");
        Films biglietto4 = new Films("Attack on Titan", 8, "B");
        Films biglietto5 = new Films("My Hero Academia", 6, "A");
        Films biglietto6 = new Films("Tokyo Revengers", 7, "C");

        biglietti.add(biglietto1);
        biglietti.add(biglietto2);
        biglietti.add(biglietto3);
        biglietti.add(biglietto4);
        biglietti.add(biglietto5);
        biglietti.add(biglietto6);
    }



    //restuitsce un biglietto del film con FIlms, riceve come parametro una richiesta e manda al cassiere che darà al cliente
    public Films vendiBiglietto(String richiesta,Cliente cliente) {

        Iterator<Films> iterator = biglietti.iterator();

        while (iterator.hasNext()) {

             Films ticket = iterator.next();

             if (ticket.getTitolo().equalsIgnoreCase(richiesta)) {

                 ticket.assegnaPosto();
                 iterator.remove();
                 biglietti_acquistati.add(ticket);

                 return ticket;
             }
        }

        return null;
    }

    public void caricaInfo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("biglietti_disponibili.txt"))) {
            for (Films ticket : biglietti) {
                pw.println("Titolo: " + ticket.getTitolo() +
                        ", Sala: " + ticket.getSala() +
                        ", Prezzo: " + ticket.getPrezzo());
            }
            System.out.println("File biglietti_disponibili.txt creato con successo!");
        } catch (IOException e) {
            System.out.println("Errore nella scrittura del file: " + e.getMessage());
        }
    }

    public void stampa() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("biglietti_acquistati.txt"))) {
            for (Films ticket : biglietti_acquistati) {
                pw.println("Titolo: " + ticket.getTitolo() +
                        ", Sala: " + ticket.getSala() +
                        ", Prezzo: " + ticket.getPrezzo() +
                        ", Posto: " + ticket.getPosto());
            }
            System.out.println("File biglietti_acquistati.txt creato con successo!");
        } catch (IOException e) {
            System.out.println("Errore nella scrittura del file: " + e.getMessage());
        }
    }


}
