public abstract class Persona {

    //dichiarazione variabili e arrayLists
    private String nome;
    private  String cognome;
    private int postoAssegnato;


    public Persona (String nome, String cognome, int postoAssegnato) {
        this.nome = nome;
        this.cognome = cognome;
        this.postoAssegnato = postoAssegnato;

    }

    //getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getPostoAssegnato() {
        return postoAssegnato;
    }

    public void setPostoAssegnato(int postoAssegnato) {
        this.postoAssegnato = postoAssegnato;
    }


    //metodi

    //metodi manager
    public void mostraBiglietti() {

    }


    public void caricaInfoFilm () {

    }


    public void stampaIncassi () {

    }


    //metodo cassiere
    public void vende (String richiesta) {

    }

    //metodo cliente
    public void acquista () {

    }


}
