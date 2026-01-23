package cinema;

public class Cliente extends persona {

    public Cliente(String nome) {
        super(nome);
    }

    @Override
    public void ruolo() {
        System.out.println("Sono un cliente");
    }
}
