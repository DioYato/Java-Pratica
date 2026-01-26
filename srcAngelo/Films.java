import java.util.ArrayList;
import java.util.Random;

public class Films {

    private String titolo;
    private int prezzo;
    private String sala;
    private int postiRimanenti = 100;
    //variabile booleana array di posti occupati
    private boolean[] postiOccupati = new boolean[101];
    private int posto;

    public Films (String titolo,int prezzo, String sala) {
      this.titolo = titolo;
      this.prezzo = prezzo;
      this.sala = sala;
      this.posto = 0;
      this.postiOccupati = new boolean[101]; // inizializza l'array
    }

    Random random = new Random ();


    public void assegnaPosto () {

        if (postiRimanenti <=0) {
            throw new IllegalStateException("Nessun posto disponibile");
        }

        int postoscelto;

        //ciclo di un array booleano,ogni indice rappresenta un posto
        do {
            postoscelto = random.nextInt(100) + 1;

        } while (postiOccupati[postoscelto]);

        //restituisce true mettendo il posto come occupato.
        postiOccupati[postoscelto]= true;
        postiRimanenti--;
        posto = postoscelto;
        System.out.println("posto assegnato" + posto);

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

}
