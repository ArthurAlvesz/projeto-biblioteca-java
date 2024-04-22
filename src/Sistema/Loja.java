package Sistema;

public class Loja extends Thread {
    private Banco banco;
    private Conta contaDaLoja;

    public Loja(Banco banco) {
        this.banco = banco;
        this.contaDaLoja = new Conta(0); 
    }

    public void run() {
       
    }

    public Conta getContaDaLoja() {
        return contaDaLoja;
    }
}