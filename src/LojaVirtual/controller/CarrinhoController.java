package LojaVirtual.controller;

import LojaVirtual.model.Carrinho;
import LojaVirtual.model.ItemCarrinho;
import LojaVirtual.model.Produto;

public class CarrinhoController {

    private static CarrinhoController instance;
    private Carrinho carrinho = new Carrinho();

    private CarrinhoController() {}

    public static CarrinhoController getInstance() {
        if (instance == null) {
            instance = new CarrinhoController();
        }
        return instance;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void adicionarProduto(Produto produto) {
    ItemCarrinho item = new ItemCarrinho(produto);
    carrinho.adicionarItem(item);
}

    public void removerItem(int index) {
        carrinho.removerItem(index);
    }
}

