package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco(10000);

        List<Loja> lojas = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lojas.add(new Loja(banco));
        }

        List<Funcionario> funcionarios = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            funcionarios.add(new Funcionario(lojas.get(i / 2)));
        }

        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            clientes.add(new Cliente(banco, 1000));
        }

        for (Cliente cliente : clientes) {
            cliente.start();
        }

        for (Funcionario funcionario : funcionarios) {
            funcionario.start();
        }

        for (Loja loja : lojas) {
            loja.start();
        }

        
        try {
            for (Cliente cliente : clientes) {
                cliente.join();
            }
            for (Funcionario funcionario : funcionarios) {
                funcionario.join();
            }
            for (Loja loja : lojas) {
                loja.join();
            }

            
            System.out.println("Saldos finais:");
            System.out.println("Saldo final da conta do banco: " + banco.getContaDoBanco().getSaldo());
            for (Loja loja : lojas) {
                System.out.println("Saldo final da conta da loja: " + loja.getContaDaLoja().getSaldo());
            }
            for (Funcionario funcionario : funcionarios) {
                System.out.println("Saldo final do salário do funcionário: " + funcionario.getSalario().getSaldo());
                System.out.println("Saldo final dos investimentos do funcionário: " + funcionario.getInvestimentos().getSaldo());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
