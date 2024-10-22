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

@WebServlet(name = "AdicionarAdmin", value = "/html/arqsJsp/administrador/addAdmin")
public class AdicionarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando o email e a senha do usuário
        String nomeCompleto = request.getParameter("nomeCompleto");
        String email = request.getParameter("email");
        String senha = request.getParameter("pass");

        AdminDAO dao = new AdminDAO();

        // AdminDAO para adicionar o novo admin
        if (dao.adicionarAdmin(nomeCompleto, email, senha)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }
    }
}


