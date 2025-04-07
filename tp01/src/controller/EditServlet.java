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

@WebServlet("/EditServlet")

public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Funcionario f = new FuncionarioDAO().buscarPorId(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Editar Funcionário</h1>");
        out.println("<form action='EditServlet' method='post'>");
        out.println("<input type='hidden' name='id' value='" + f.getId() + "'/>");
        out.println("Nome: <input type='text' name='name' value='" + f.getName() + "'/><br/>");
        out.println("Email: <input type='email' name='email' value='" + f.getEmail() + "'/><br/>");
        out.println("Cargo: <input type='text' name='country' value='" + f.getCountry() + "'/><br/>");
        out.println("<input type='submit' value='Atualizar'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Funcionario f = new Funcionario();
        f.setId(Integer.parseInt(request.getParameter("id")));
        f.setName(request.getParameter("name"));
        f.setEmail(request.getParameter("email"));
        f.setCountry(request.getParameter("country"));

        new FuncionarioDAO().atualizar(f);

        response.sendRedirect("ViewServlet");
    }
}
