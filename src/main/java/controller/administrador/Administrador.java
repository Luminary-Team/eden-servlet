package controller.administrador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import model.Admin;

@WebServlet(name = "Administrador", value = "/jsp/areaRestrita/admins")
public class Administrador extends HttpServlet {
    // Expressões regulares
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        List<Admin> adminList = new ArrayList<>(); // É criado uma lista para passar uma lista para a pagina jsp


        // O método "getAdms" serve para dar um SELECT na tabela de administrador do banco e pega-se o valor das colunas do banco
        // atribuindo valores numa variável.

        try {
            ResultSet rs = dao.getAdms();
            while (rs.next()) {
                int id = rs.getInt("ID_ADMINISTRATOR");
                String nome = rs.getString("FULL_NAME");
                String email = rs.getString("EMAIL");
                String senha = rs.getString("PASSWORD");
                adminList.add(new Admin(id, nome, email, senha));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            // Caso ocorra um erro, identifico esse erro e mando um atributo com o porquê desse erro para a jsp.
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/jsp/areaRestrita/erro.jsp").forward(request, response);
        }

        // Define o atributo para a lista de administradores
        request.setAttribute("adminList", adminList);
        // Encaminha para a página JSP de listagem de administradores
        request.getRequestDispatcher("/jsp/areaRestrita/edenAreaRestritaPrimeiros_admins.jsp").forward(request, response);
    }
}
