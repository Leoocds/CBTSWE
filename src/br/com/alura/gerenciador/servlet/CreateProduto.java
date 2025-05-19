package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.servlet.Banco;
import br.com.alura.gerenciador.servlet.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/create")
public class CreateProduto extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
        String descricao = request.getParameter("descricao");
        double qtdPrevistoMes = Double.parseDouble(request.getParameter("qtdPrevistoMes"));
        double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setUnidadeCompra(unidadeCompra);
        produto.setDescricao(descricao);
        produto.setQtdPrevistoMes(qtdPrevistoMes);
        produto.setPrecoMaxComprado(precoMaxComprado);

        Banco banco = new Banco();
        banco.adiciona(produto);

        response.sendRedirect("listarProd.jsp");
    }
}
