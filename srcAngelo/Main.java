import java.util.ArrayList;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            // Creo gli oggetti principali
            Manager manager = new Manager("Mario", "Rossi", 0);
            Cassiere cassiere = new Cassiere("Luigi", "Verdi", 0);
            Cliente cliente = new Cliente("Anna", "Bianchi", 0);

            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- MENU CINEMA ---");
                System.out.println("1) Acquista biglietto");
                System.out.println("2) Carica biglietti disponibili su file");
                System.out.println("3) Stampa biglietti acquistati su file");
                System.out.println("4) Esci");
                System.out.print("Scelta: ");

                int scelta = input.nextInt();
                input.nextLine(); // Consuma il \n rimasto

                switch (scelta) {
                    case 1:
                        // Cliente acquista biglietto
                        cliente.acquista(cassiere, manager);
                        break;
                    case 2:
                        // Carica biglietti disponibili
                        manager.caricaInfo();
                        break;
                    case 3:
                        // Stampa biglietti acquistati
                        manager.stampa();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Uscita dal programma...");
                        break;
                    default:
                        System.out.println("Scelta non valida, riprova.");
                }
            }

            input.close();
        }
    }
