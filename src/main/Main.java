package main;

public class Main {

    public static void main(String[] args) {
        //Iniciano Contas
        Cliente joao = new Cliente();
        joao.setNome("João");

        Cliente marcelo = new Cliente();
        marcelo.setNome("Marcelo");

        Conta ccJoao = new ContaCorrente(joao);
        Conta ccMarcelo = new ContaCorrente(marcelo);
        Conta poupancaMarcelo = new ContaPoupanca(marcelo);

        //Ações
        ccJoao.depositar(100);

        ccJoao.transferir(40, poupancaMarcelo);

        poupancaMarcelo.transferir(25, ccMarcelo);

        //Mostrando na Tela
        ccJoao.imprimirExtrato();
        ccMarcelo.imprimirExtrato();
        poupancaMarcelo.imprimirExtrato();
    }
}
