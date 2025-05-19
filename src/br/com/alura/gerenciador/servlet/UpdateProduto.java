package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.servlet.Banco;
import br.com.alura.gerenciador.servlet.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update")
public class UpdateProduto extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
        String descricao = request.getParameter("descricao");
        double qtdPrevistoMes = Double.parseDouble(request.getParameter("qtdPrevistoMes"));
        double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));

        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setId(id);
        produtoAtualizado.setNome(nome);
        produtoAtualizado.setUnidadeCompra(unidadeCompra);
        produtoAtualizado.setDescricao(descricao);
        produtoAtualizado.setQtdPrevistoMes(qtdPrevistoMes);
        produtoAtualizado.setPrecoMaxComprado(precoMaxComprado);

        Banco banco = new Banco();
        banco.atualiza(produtoAtualizado);

        response.sendRedirect("listarProd.jsp");
    }
}
