package cinema;

public class Main {

    public static void main(String[] args) {

        // 1) Creo il manager
        Manager manager = new Manager("Direttore");

        // 2) Carico i film dal file
        manager.caricaFilmDaFile("film.txt");

        // 3) Creo alcuni cassieri
        Cassiere c1 = new Cassiere("Marco");
        Cassiere c2 = new Cassiere("Luca");

        manager.aggiungiCassiere(c1);
        manager.aggiungiCassiere(c2);

        // 4) Creo alcuni clienti
        Cliente cl1 = new Cliente("Pietro");
        Cliente cl2 = new Cliente("Giulia");

        // 5) Simulo alcune vendite
        c1.vendiBiglietti(cl1, manager.getListaFilm().get(0), 2); // Pietro compra 2 biglietti del primo film
        c2.vendiBiglietti(cl2, manager.getListaFilm().get(1), 3); // Giulia compra 3 biglietti del secondo film

        // 6) Genero il report finale
        manager.generaReport("report.txt");

        System.out.println("Programma terminato.");
    }
}
