//package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lanchonete {
    private static List<Lanche> lanches = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Lanche pizza = new Lanche("Pizza", 6.00);
        Lanche coxinha = new Lanche("Coxinha", 4.00);
        Lanche empada = new Lanche("Empada", 3.00);
        Lanche pastelForno = new Lanche("Pastel de Forno", 5.00);
        Lanche esfiha = new Lanche("Esfiha", 2.50);
        Lanche pastel = new Lanche("Pastel de Carne", 4.50);
        Lanche caldoCana = new Lanche("Caldo de Cana", 2.50);

        lanches.add(pizza);
        lanches.add(coxinha);
        lanches.add(empada);
        lanches.add(pastelForno);
        lanches.add(esfiha);
        lanches.add(pastel);
        lanches.add(caldoCana);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Olá! Qual lanche você gostaria?");
            System.out.println("1 | Pizza - [6,00]");
            System.out.println("2 | Coxinha - [4,00]");
            System.out.println("3 | Empada - [3,00]");
            System.out.println("4 | Pastel de Forno - [5,00]");
            System.out.println("5 | Esfiha - [2,50]");
            System.out.println("6 | Pastel de Carne - [4,50]");
            System.out.println("7 | Caldo de Cana - [2,50]");

            int codigo = scanner.nextInt();

            if (codigo < 1 || codigo > 7) {
                System.out.println("Não foi encontrado nenhum item com esse código. ");
                continue;
            }

            System.out.println("Agora, escolha a quantidade:");
            int quantidade = scanner.nextInt();

            Lanche lancheEscolhido = lanches.get(codigo - 1);
            Pedido pedido = new Pedido(lancheEscolhido, quantidade);
            pedidos.add(pedido);

            System.out.println("Adicionar mais algum item? (s / n)");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
        fecharPedido();
    }

    private static void fecharPedido() {
        double totalpedido = 0;
        System.out.println("Seu pedido:");
        for (Pedido pedido : pedidos) {
            double valorPedido = pedido.getLanche().getPreco() * pedido.getQuantidade();
            System.out.println(pedido.getQuantidade() + " x " + pedido.getLanche().getNome() + " = " + valorPedido);

            totalpedido += valorPedido;
        }
        System.out.println("Total do pedido: " + totalpedido);
    }
}

class Lanche {
    private String nome;
    private double preco;
    public Lanche(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
}

class Pedido {
    private Lanche lanche;
    private int quantidade;
    public Pedido(Lanche lanche, int quantidade) {
        this.lanche = lanche;
        this.quantidade = quantidade;
    }
    public Lanche getLanche() {
        return lanche;
    }
    public int getQuantidade() {
        return quantidade;
    }
}