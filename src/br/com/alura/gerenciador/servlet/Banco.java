package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;
import br.com.alura.gerenciador.servlet.Produto;

public class Banco {

    private static List<Produto> lista = new ArrayList<>();
    private static int contadorIds = 1;

    static {
        Produto p1 = new Produto(contadorIds++, "Caneta", 10, "Caneta azul", 100.0, 1.50);
        Produto p2 = new Produto(contadorIds++, "Caderno", 5, "Caderno 100 folhas", 50.0, 15.0);
        lista.add(p1);
        lista.add(p2);
    }

    public void adiciona(Produto produto) {
        produto.setId(contadorIds++);
        lista.add(produto);
    }

    public List<Produto> getProdutos() {
        return lista;
    }

    public Produto buscaPorId(int id) {
        for (Produto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void remove(int id) {
        Produto produto = buscaPorId(id);
        if (produto != null) {
            lista.remove(produto);
        }
    }

    public void atualiza(Produto produtoAtualizado) {
        Produto produto = buscaPorId(produtoAtualizado.getId());
        if (produto != null) {
            produto.setNome(produtoAtualizado.getNome());
            produto.setUnidadeCompra(produtoAtualizado.getUnidadeCompra());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setQtdPrevistoMes(produtoAtualizado.getQtdPrevistoMes());
            produto.setPrecoMaxComprado(produtoAtualizado.getPrecoMaxComprado());
        }
    }
}
