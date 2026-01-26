import java.util.Scanner;

public class Cliente extends Persona{

    public Cliente (String nome, String cognome, int postoAssegnato) {
        super(nome,cognome,postoAssegnato);
    }

    Scanner input = new Scanner(System.in);


    public void acquista(Cassiere cassiere, Manager manager) {
        System.out.println("Inserisci il nome del film da acquistare:");

        String richiesta = input.nextLine();

        // Passa sé stesso al Cassiere
        cassiere.vende(richiesta, manager, this);
    }



}
