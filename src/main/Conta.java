package main;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numeroDaConta;
    protected double saldo;
    protected Cliente nomeCliente;
    public Conta(Cliente nomeCliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroDaConta = SEQUENCIAL++;
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.nomeCliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numeroDaConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
