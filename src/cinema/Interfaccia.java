package cinema;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interfaccia {
    private List<Manager> listaManager = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Cliente cliente = new Cliente("Andrea", "Gatti");

    public void inizio() {
        this.aggiungiManager();

        System.out.println("Benvenuto!");

        while (true) {
            System.out.println();

            System.out.println("0. Esci");
            System.out.println("1. Acquista biglietti");
            System.out.println("2. Stampa report di incasso");

            System.out.print("Seleziona: ");

            int input = scanner.nextInt();

            switch (input) {
                case 0:
                    return;
                case 1:
                    this.selezioneManager();
                    break;
                case 2:
                    this.stampaReport();
                    break;
                default:
                    System.out.println("Selezione invalida");
            }
        }
    }

    public void aggiungiManager() {
        Manager manager1 = new Manager("Mario", "Rossi");

        manager1.aggiungiCassiere(new Cassiere("Giulia", "Ferrari"));
        manager1.aggiungiCassiere(new Cassiere("Francesco", "Esposito"));
        manager1.aggiungiCassiere(new Cassiere("Sofia", "Bianchi"));

        try {
			manager1.caricaCatalogo("catalogo_mario.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File di catalogo non trovato");
		}

        this.listaManager.add(manager1);

        Manager manager2 = new Manager("Alessandro", "Romano");

        manager2.aggiungiCassiere(new Cassiere("Elena", "Colombo"));
        manager2.aggiungiCassiere(new Cassiere("Luca", "Ricci"));
        manager2.aggiungiCassiere(new Cassiere("Chiara", "Marino"));

        try {
			manager2.caricaCatalogo("catalogo_alessandro.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File di catalogo non trovato");
		}

        this.listaManager.add(manager2);
    }

    public void selezioneManager() {
        while (true) {
            System.out.println();

            for (int i = 0; i < listaManager.size(); i++) {
                System.out.printf("%d. %s\n", i+1, listaManager.get(i).getNomeCompleto());
            }

            System.out.print("Seleziona manager, o premi 0 per uscire: ");

            int input = scanner.nextInt();

            if (input == 0) {
                return;
            }

            try {
                Manager manager = listaManager.get(input-1);
                this.selezioneCassiere(manager);
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selezione invalida");
            }
        }
    }

    public void selezioneCassiere(Manager manager) {
        while (true) {
            System.out.println();

            List<Cassiere> cassieri = manager.getCassieri();

            for (int i = 0; i < cassieri.size(); i++) {
                System.out.printf("%d. %s\n", i+1, cassieri.get(i).getNomeCompleto());
            }

            System.out.print("Seleziona cassiere, o premi 0 per uscire: ");

            int input = scanner.nextInt();

            if (input == 0) {
                return;
            }

            try {
                Cassiere cassiere = cassieri.get(input-1);
                this.selezioneFilm(cassiere, manager.getCatalogo());
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selezione invalida");
            }
        }
    }

    public void selezioneFilm(Cassiere cassiere, List<Film> catalogo) {
        while (true) {
            System.out.println();

            for (int i = 0; i < catalogo.size(); i++) {
                System.out.printf("%d. %s\n", i+1, catalogo.get(i).getNome());
            }

            System.out.print("Seleziona film, o premi 0 per uscire: ");

            int input = scanner.nextInt();

            if (input == 0) {
                return;
            }

            try {
                Film film = catalogo.get(input-1);
                this.acquistoBiglietti(cassiere, film);
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selezione invalida");
            }
        }
    }

    public void acquistoBiglietti(Cassiere cassiere, Film film) {
        while (true) {
            System.out.println();

            double prezzo = film.getCostoBiglietto();

            System.out.printf("Nome film: %s\n", film.getNome());
            System.out.printf("Costo biglietto: %.2f\n", prezzo);

            System.out.print("Inserisci quantità biglietti, o premi 0 per uscire: ");

            int input = scanner.nextInt();

            if (input == 0) {
                return;
            }

            try {
                cassiere.vendiBiglietto(this.cliente, film, input);
                System.out.println("Biglietti acquistati!");
                return;
            } catch (Exception e) {
                System.out.printf("Errore: %s\n", e.getMessage());
            }
        }
    }

    public void stampaReport() {
        while (true) {
            System.out.println();

            for (int i = 0; i < listaManager.size(); i++) {
                System.out.printf("%d. %s\n", i+1, listaManager.get(i).getNomeCompleto());
            }

            System.out.print("Seleziona manager, o premi 0 per uscire: ");

            int input = scanner.nextInt();

            if (input == 0) {
                return;
            }

            try {
                Manager manager = listaManager.get(input-1);
                manager.stampaReport();
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selezione invalida");
            }
        }
    }
}