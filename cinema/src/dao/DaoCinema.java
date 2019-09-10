/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Cinema;
/**
 *
 * @author Administrador
 */
public class DaoCinema {
    public static boolean inserir(Cinema objeto) {
        String sql = "INSERT INTO cinema (endereco, capacidade) VALUES (?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getEndereco());
            ps.setInt(2, objeto.getCapacidade());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
public static void main(String[] args) {
        Cinema objeto = new Cinema();
        objeto.setEndereco("Bairro");
        objeto.setCapacidade(100000);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
