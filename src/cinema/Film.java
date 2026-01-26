package cinema;
public class Film {
    private final String nome;
    private final double costoBiglietto;
    private int postiDisponbili;

    public Film(String nome, double costoBiglietto, int postiDisponbili) {
        this.nome = nome;
        this.costoBiglietto = costoBiglietto;
        this.postiDisponbili = postiDisponbili;
    }

    public double getCostoBiglietto() {
        return costoBiglietto;
    }

    public String getNome() {
        return nome;
    }

    public void sottraiPosti(int posti) throws Exception {
        if (postiDisponbili < posti) {
            throw new Exception("Posti disponibili non sufficienti");
        }

        postiDisponbili -= posti;
    }
}
