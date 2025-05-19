package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import br.com.alura.gerenciador.servlet.Banco;
import br.com.alura.gerenciador.servlet.Produto;

/**
 *
 */
@WebServlet("/editar")
public class EditProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Banco banco = new Banco();
        Produto produto = banco.buscaPorId(id);

        if (produto != null) {
            request.setAttribute("produto", produto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("listarProd.jsp");
        }
    }
}
