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

@WebServlet(name = "AdicionarAdmin", value = "/HTMLS/arqsJsp/administrador/addAdmin")
public class AdicionarAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegando o email e a senha do usuário
        String nomeCompleto = request.getParameter("nomeCompleto");
        String email = request.getParameter("email");
        String senha = request.getParameter("pass");

        AdminDAO dao = new AdminDAO();
        int id=0;

        // Lógica para pegar o id novo
        try {
            ResultSet rs = dao.getAdms();
            while (rs.next()) {
                id ++;
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
            System.out.println("Nao foi possivel achar nenhum resultado");
        }

        // AdminDAO para adicionar o novo admin
        AdminDAO adminDAO = new AdminDAO();
        if (adminDAO.adicionarAdmin(id+1,nomeCompleto, email, senha)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/HTMLS/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/HTMLS/arqsJsp/inseridoErro.jsp");
        }
    }
}


