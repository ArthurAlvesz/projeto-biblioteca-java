package Sistema;

public class Funcionario extends Thread {
    private Loja loja;
    private Conta salario;
    private Conta investimentos;

    public Funcionario(Loja loja) {
        this.loja = loja;
        this.salario = new Conta(0); 
        this.investimentos = new Conta(0); 
    }

    public void run() {
        while (true) {
            synchronized (loja) {
                if (loja.getContaDaLoja().getSaldo() >= 1400) {
                    loja.getContaDaLoja().sacar(1400); // Sacar o salário da conta da loja
                    salario.depositar(1400); // Receber o salário
                    double valorInvestimento = 1400 * 0.2; // Calcular valor do investimento (20% do salário)
                    investimentos.depositar(valorInvestimento); // Investir parte do salário
                    System.out.println("Salário recebido e investido em contas de investimento");
                    System.out.println("Salário atual: " + salario.getSaldo());
                    System.out.println("Investimentos atuais: " + investimentos.getSaldo());
                }
            }
            try {
                Thread.sleep(1000); // Espera 1 segundo antes de verificar novamente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Conta getSalario() {
        return salario;
    }

    public Conta getInvestimentos() {
        return investimentos;
    }
}
