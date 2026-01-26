package cinema;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Manager extends Persona {
    private final List<Cassiere> cassieri = new ArrayList<>();
    private final List<Film> catalogo = new ArrayList<>();

    public Manager(
            String nome,
            String cognome
    ) {
        super(nome, cognome);
    }

    public void aggiungiCassiere(Cassiere cassiere) {
        cassieri.add(cassiere);
    }

    public void caricaCatalogo(String nomeFileCatalogo) throws FileNotFoundException {
        File fileCatalogo = new File(nomeFileCatalogo);
        Scanner scanner = new Scanner(fileCatalogo);

        while (scanner.hasNextLine()) {
            String nomeFilm = scanner.nextLine();
            double costoBiglietto = scanner.nextDouble();
            int postiDisponibili = scanner.nextInt();

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            catalogo.add(new Film(nomeFilm, costoBiglietto, postiDisponibili));
        }
    }

    public List<Cassiere> getCassieri() {
        return cassieri;
    }

    public List<Film> getCatalogo() {
        return catalogo;
    }

    public void stampaReport() {
        double incassoTotale = 0.0;
        for (Cassiere cassiere : cassieri) {
            incassoTotale += cassiere.getIncasso();
        }

        List<Cassiere> cassieriOrdinati = new ArrayList<>(cassieri);
        cassieriOrdinati.sort(Comparator.comparingDouble(Cassiere::getIncasso));

        String nomeFile = String.format("%s Incasso.txt", this.getNomeCompleto());

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            writer.printf("Incasso totale: %.2f€\n\n", incassoTotale);

            writer.println("Cassieri:");
            for (Cassiere cassiere : cassieriOrdinati) {
                writer.printf("%s: %.2f€\n", cassiere.getNomeCompleto(), cassiere.getIncasso());
            }
        } catch (IOException e) {
            System.out.println("Errore nella scrittura del report.");
        }

        System.out.printf("Report salvato in file: %s\n", nomeFile);
    }
}
