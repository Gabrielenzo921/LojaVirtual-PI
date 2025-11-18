package LojaVirtual.dao;

import LojaVirtual.jdbc.Conexao;
import LojaVirtual.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import LojaVirtual.model.Produto;       
import java.sql.Connection;             
import java.sql.PreparedStatement;      
import java.sql.ResultSet;              
import java.util.ArrayList;             
import java.util.List;                
import javax.swing.JOptionPane;
import LojaVirtual.model.Produto;

public class ProdutosDAO {
    
    private Connection con;
    
    public ProdutosDAO() {
        this.con = new Conexao().getConnection();
    }
    
    // Método para listar produtos do banco
    public List<Produto> listarProdutos() {
        try {
            List<Produto> lista = new ArrayList<>();
            String sql = "SELECT * FROM produtos";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                // ATENÇÃO: Os nomes aqui devem ser iguais aos da tabela do banco
                p.setId(rs.getInt("id")); 
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                
                lista.add(p);
            }
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
            return null;
        }
    }
}