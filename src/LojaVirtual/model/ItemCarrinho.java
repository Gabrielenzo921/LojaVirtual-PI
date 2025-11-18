package LojaVirtual.model;

public class ItemCarrinho {

    private Produto produto;

    public ItemCarrinho(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getNomeProduto() {
        return produto.getNome();
    }
}
