package br.com.bancodigital;

import br.com.bancodigital.model.Cliente;
import br.com.bancodigital.model.Conta;
import br.com.bancodigital.model.ContaCorrente;
import br.com.bancodigital.model.ContaPoupanca;
import br.com.bancodigital.exception.SaldoInsuficienteException;
import br.com.bancodigital.service.Banco;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Maria");
        Cliente cliente2 = new Cliente("João");

        Conta contaCorrente = new ContaCorrente(cliente1);
        Conta contaPoupanca = new ContaPoupanca(cliente2);

        Banco banco = new Banco("Banco Digital");
        banco.adicionarConta(contaCorrente);
        banco.adicionarConta(contaPoupanca);

        // Teste criar conta
        System.out.println("=== Saldo após criação: ===");
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
        System.out.println();


        // Teste de Depósito
        System.out.println("=== Depósito de 1000 reais na Conta Corrente ===");
        contaCorrente.depositar(1000);
        contaCorrente.imprimirExtrato();
        System.out.println();


        // Teste de Transferência
        System.out.println("=== Transferência de 300 da Conta Corrente para a Conta Poupança ===");
        try {
            contaCorrente.transferir(300, contaPoupanca);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
        System.out.println();


        // Teste de Saque
        System.out.println("=== Saque de 900 da Conta Corrente ===");
        try {
            contaCorrente.sacar(900); // Vai lançar exceção
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}
