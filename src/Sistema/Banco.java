package Sistema;

import java.util.List;

public class Banco {
    private Conta contaDoBanco;

    public Banco(double saldoInicial) {
        this.contaDoBanco = new Conta(saldoInicial);
    }

    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        origem.sacar(valor);
        destino.depositar(valor);
    }

    public synchronized Conta getContaDoBanco() {
        return contaDoBanco;
    }

    public synchronized void exibirSaldosFinais(List<Conta> contas) {
        for (Conta conta : contas) {
            System.out.println("Saldo final da conta: " + conta.getSaldo());
        }
    }
}
