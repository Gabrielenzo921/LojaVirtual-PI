package LojaVirtual.model;

import java.util.ArrayList;

public class Carrinho {

    private ArrayList<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public void removerItem(int index) {
        itens.remove(index);
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }
}
