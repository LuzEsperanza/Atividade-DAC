/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Conexao {

    public static Connection abrirConexao() {
        ;
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5434/dac-jsf",
                    "postgres", "12345");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoasJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void fecharConexao(Connection connec) {
        try {
            connec.close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoasJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
