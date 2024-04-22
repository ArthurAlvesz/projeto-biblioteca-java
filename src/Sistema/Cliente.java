package Sistema;

import java.util.Random;

public class Cliente extends Thread {
    private Banco banco;
    private double saldoInicial;

    public Cliente(Banco banco, double saldoInicial) {
        this.banco = banco;
        this.saldoInicial = saldoInicial;
    }

    public void run() {
        Random random = new Random();
        Conta conta = new Conta(saldoInicial);
        while (conta.getSaldo() > 0) {
            int valorCompra = random.nextBoolean() ? 100 : 200;
            synchronized (banco) {
                if (conta.getSaldo() >= valorCompra) {
                    banco.transferir(conta, banco.getContaDoBanco(), valorCompra); 
                    System.out.println("Compra realizada: R$" + valorCompra);
                } else {
                    break; 
                }
            }
        }
        System.out.println("Cliente terminou suas compras.");
    }
}
