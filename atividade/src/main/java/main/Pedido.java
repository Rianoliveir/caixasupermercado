/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rcosta
 */
public class Pedido {

    public void Createpedido(PedidoModel pedidoModel) {
        String sql = "INSERT INTO caixa (nome_produto, quantidade, valor_total) VALUES (?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexao.Conexao.ConexaoSQL();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pedidoModel.getNome_produto());
            preparedStatement.setInt(2, pedidoModel.getQuantidade());
            preparedStatement.setDouble(3, pedidoModel.getValor_total());

            preparedStatement.execute();

        } catch (Exception e) {

            System.out.println(e + "Erro ao efetuar o pedido");

        }
    }

    public List<PedidoModel> mostrarPedidos() throws Exception {
        String sql = "SELECT * FROM caixa";

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        ArrayList<PedidoModel> pedidos = new ArrayList<PedidoModel>();

        try {
            connection = conexao.Conexao.ConexaoSQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PedidoModel pedidoModel = new PedidoModel();
                pedidoModel.setId(resultSet.getInt("id_cliente"));
                pedidoModel.setNome_produto(resultSet.getString("nome_produto"));
                pedidoModel.setQuantidade(resultSet.getInt("quantidade"));
                pedidoModel.setValor_total(resultSet.getDouble("valor_total"));

                pedidos.add(pedidoModel);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao mostrar pedidos: " + e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e);
            }
        }

        return pedidos;
    }
}
