package LojaVirtual.dao;

import LojaVirtual.jdbc.Conexao;
import LojaVirtual.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    private Connection con;

    public UsuarioDAO() {
        this.con = new Conexao().getConnection();
    }

    // Método para Cadastrar (Insert)
    public void cadastrarUsuario(Usuario u) {
        try {
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha()); // Idealmente use criptografia real!

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e);
        }
    }

    // Método para Login (Select)
    public Usuario fazerLogin(String email, String senha) {
        try {
            String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                return u; // Retorna o objeto Usuário logado
            } else {
                return null; // Usuário ou senha incorretos
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no login: " + e);
            return null;
        }
    }
}