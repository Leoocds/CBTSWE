package controller;

import dao.FuncionarioDAO;
import model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")

public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Funcionario> lista = new FuncionarioDAO().listar();

        out.println("<html><body>");
        out.println("<h1>Lista de Funcionários</h1>");
        out.println("<a href='index.html'>Adicionar Novo</a><br><br>");
        out.println("<table border='1'><tr><th>ID</th><th>Nome</th><th>Email</th><th>Cargo</th><th>Ações</th></tr>");

        for (Funcionario f : lista) {
            out.println("<tr><td>" + f.getId() + "</td><td>" + f.getName() + "</td><td>" + f.getEmail() +
                    "</td><td>" + f.getCountry() + "</td><td><a href='EditServlet?id=" + f.getId() +
                    "'>Editar</a> | <a href='DeleteServlet?id=" + f.getId() +
                    "'>Deletar</a></td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
