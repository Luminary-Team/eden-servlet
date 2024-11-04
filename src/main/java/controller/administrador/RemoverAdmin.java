package controller.administrador;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "RemoverAdmin", value = "/jsp/arqsJsp/administrador/rmvAdmin")
public class RemoverAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        // Pego o valor passado da jsp quando se chama esssa classe
        int id = Integer.parseInt(request.getParameter("id-admin"));

        // AdminDAO para remover um admin
        if (dao.removeAdmin(id)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/jsp/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/jsp/arqsJsp/inseridoErro.jsp");
        }
    }
}


