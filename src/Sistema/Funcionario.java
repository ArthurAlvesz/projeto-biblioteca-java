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
      
    }

    public Conta getSalario() {
        return salario;
    }

    public Conta getInvestimentos() {
        return investimentos;
    }
}