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

@WebServlet("/SaveServlet")

public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String cargo = request.getParameter("country");

        Funcionario f = new Funcionario();
        f.setName(name);
        f.setEmail(email);
        f.setCountry(cargo);

        FuncionarioDAO dao = new FuncionarioDAO();
        dao.salvar(f);

        response.sendRedirect("ViewServlet");
    }
}
