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

@WebServlet(name = "Administrador", value = "/html/areaRestrita/admins")
public class Administrador extends HttpServlet {
    // Expressões regulares
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO dao = new AdminDAO();
        List<Admin> adminList = new ArrayList<>();

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
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/html/areaRestrita/erro.jsp").forward(request, response);
        }

        // Define o atributo para a lista de administradores
        request.setAttribute("adminList", adminList);
        // Encaminha para a página JSP de listagem de administradores
        request.getRequestDispatcher("/html/areaRestrita/edenAreaRestritaPrimeiros_admins.jsp").forward(request, response);
    }
}
