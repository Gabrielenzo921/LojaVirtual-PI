package LojaVirtual.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConnection() {
        try {
            // Verifique se o usuario e senha do seu MySQL sao esses mesmos (root/root ou root/vazio)
            return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual", "root", "Engugf@1502");
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados: " + e);
        }
    }
}