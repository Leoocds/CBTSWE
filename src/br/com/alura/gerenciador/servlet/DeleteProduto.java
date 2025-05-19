package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.servlet.Banco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/excluir")
public class DeleteProduto extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Banco banco = new Banco();
        banco.remove(id);

        response.sendRedirect("listarProd.jsp");
    }
}
