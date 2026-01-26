package cinema;
public abstract class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNomeCompleto() {
        return String.format("%s %s", this.nome, this.cognome);
    }
}
