package br.com.bancodigital.model;
import br.com.bancodigital.exception.SaldoInsuficienteException;


public abstract class Conta {
    protected static final String AGENCIA_PADRAO = "0001";

    protected String agencia;
    protected int numeroConta;
    protected Cliente cliente;
    protected double saldo;

    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= saldo) {
            this.saldo -= valor;
        } else {
            throw new SaldoInsuficienteException("Erro: Saldo insuficiente para saque!");
        }
    }

    public void transferir(double valor, Conta destino) throws SaldoInsuficienteException {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void imprimirExtrato() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numeroConta);
        System.out.printf("Saldo: R$ %.2f\n", saldo);
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
