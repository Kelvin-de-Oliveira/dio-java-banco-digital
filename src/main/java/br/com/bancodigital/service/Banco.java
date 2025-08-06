package br.com.bancodigital.service;

import br.com.bancodigital.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void listarContas() {
        System.out.println("=== Contas no banco " + nome + " ===");
        for (Conta conta : contas) {
            conta.imprimirExtrato();
            System.out.println();
        }
    }
}
