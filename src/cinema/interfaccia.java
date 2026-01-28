package cinema;

import javax.swing.*;
import java.awt.*;

public class interfaccia {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cinema");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel titolo = new JLabel("Acquisto biglietti");
        JTextField nomeCliente = new JTextField(15);
        nomeCliente.setToolTipText("Nome cliente");

        JTextField nomeFilm = new JTextField(15);
        nomeFilm.setToolTipText("Titolo film");

        JTextField quantita = new JTextField(5);
        quantita.setToolTipText("Quantità");

        JButton acquista = new JButton("Acquista");

        JTextArea output = new JTextArea(8, 30);
        output.setEditable(false);

        frame.add(titolo);
        frame.add(nomeCliente);
        frame.add(nomeFilm);
        frame.add(quantita);
        frame.add(acquista);
        frame.add(new JScrollPane(output));

        
        acquista.addActionListener(e -> {
            try {
                String nome = nomeCliente.getText();
                String filmTitolo = nomeFilm.getText();
                int q = Integer.parseInt(quantita.getText());

                Cliente c = new Cliente(nome);
                Film f = new Film(filmTitolo, 100, 10.0);

                Cassiere cassiere = new Cassiere("Mario");

                boolean ok = cassiere.vendiBiglietti(c, f, q);

                if (ok) {
                    output.append("OK: " + nome + " ha acquistato " + q + " biglietti per " + filmTitolo + "\n");
                } else {
                    output.append("ERRORE: posti insufficienti per " + filmTitolo + "\n");
                }

            } catch (Exception ex) {
                output.append("Errore nei dati inseriti\n");
            }
        });

        frame.setVisible(true);
    }
}


