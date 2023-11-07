/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
 
/**
 *
 * @author rcosta
 */
public class PedidoModel {
 private int id;

 private String nome_produto;

 private int quantidade;
 
 private double valor_total;

    public PedidoModel() {
    }

    public PedidoModel(int id, String nome_produto, int quantidade, double valor_total) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

   
    
}
