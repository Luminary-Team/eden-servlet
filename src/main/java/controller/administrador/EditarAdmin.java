package controller.administrador;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "EditarAdmin", value = "/html/arqsJsp/areaRestrita/editarAdmin")
public class EditarAdmin extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando o email e a senha do usuário
        int id = Integer.parseInt(request.getParameter("id-admin"));
        String nomeCompleto = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        System.out.println(id);
        AdminDAO dao = new AdminDAO();

        if (dao.editarAdmin(id, nomeCompleto, email, senha)){
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }
    }
}
