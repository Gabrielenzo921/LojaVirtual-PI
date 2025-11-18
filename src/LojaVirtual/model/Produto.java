package LojaVirtual.model;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private double preco;

// ----------------------------------------------------------------------
// 1. CONSTRUTORES
// ----------------------------------------------------------------------

    // CONSTRUTOR 1: Construtor Vazio (Default)
    // NECESSÁRIO para o DAO, pois permite criar o objeto vazio (new Produto())
    // e preenchê-lo linha por linha com os Setters dentro do loop while (rs.next()).
    public Produto() {
    }
    
    // CONSTRUTOR 2: Construtor Completo (Parameterized)
    // Útil para quando você precisa criar o objeto com todos os dados de uma vez.
    public Produto(int id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

// ----------------------------------------------------------------------
// 2. GETTERS
// ----------------------------------------------------------------------
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

// ----------------------------------------------------------------------
// 3. SETTERS
// ----------------------------------------------------------------------

    // Setters são NECESSÁRIOS para que o ProdutosDAO possa
    // pegar os dados do banco (ResultSet) e atribuir ao objeto.
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
// ----------------------------------------------------------------------
// 4. TO STRING (Já existia no seu código)
// ----------------------------------------------------------------------

    @Override
    public String toString() {
        return nome;
    }
}