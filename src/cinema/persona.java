package cinema;

public abstract class persona {
    protected String nome;

    public persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Metodo astratto per il polimorfismo
    public abstract void ruolo();
}
