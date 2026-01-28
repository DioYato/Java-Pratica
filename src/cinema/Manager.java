package cinema;

import java.util.ArrayList;
import java.util.List;

public class Manager extends persona {

    private List<Film> listaFilm = new ArrayList<>();
    private List<Cassiere> cassieri = new ArrayList<>();

    public Manager(String nome) {
        super(nome);
    }

    public void aggiungiCassiere(Cassiere c) {
        cassieri.add(c);
    }

    public List<Cassiere> getCassieri() {
        return cassieri;
    }

    public void aggiungiFilm(Film f) {
        listaFilm.add(f);
    }

    public List<Film> getListaFilm() {
        return listaFilm;
    }

    @Override
    public void ruolo() {
        System.out.println("Sono un manager");
    }
    
    public void caricaFilmDaFile(String nomeFile) {
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(nomeFile))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parti = linea.split(";");
                String titolo = parti[0];
                int posti = Integer.parseInt(parti[1]);
                double prezzo = Double.parseDouble(parti[2]);

                Film f = new Film(titolo, posti, prezzo);
                aggiungiFilm(f);
            }
            System.out.println("Film caricati correttamente.");
        } catch (Exception e) {
            System.out.println("Errore nel caricamento dei film: " + e.getMessage());
        }
    }

    public void generaReport(String nomeFile) {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(nomeFile)) {

            // Incasso totale
            double totale = 0;
            for (Cassiere c : cassieri) {
                totale += c.getIncasso();
            }

            pw.println("INCASSO TOTALE CINEMA: " + totale + " euro");
            pw.println();

            
            pw.println("CASSIERI ORDINATI PER INCASSO:");
            cassieri.stream()
                    .sorted((a, b) -> Double.compare(a.getIncasso(), b.getIncasso()))
                    .forEach(c -> pw.println(c.getNome() + " - " + c.getIncasso() + " euro"));

            System.out.println("Report generato correttamente.");

        } catch (Exception e) {
            System.out.println("Errore nella generazione del report: " + e.getMessage());
        }
    }

    

}
