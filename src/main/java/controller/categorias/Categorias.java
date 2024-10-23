package controller.categorias;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDAO;
import dao.CategoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import model.Admin;
import model.Categ;

@WebServlet(name = "Categorias", value = "/html/areaRestrita/categ")
public class Categorias extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoDAO dao = new CategoDAO();
        List<Categ> categList = new ArrayList<>();

        try {
            ResultSet rs = dao.getCategorias();
            while (rs.next()) {
                int id = rs.getInt("PK_ID");
                String category = rs.getString("CATEGORY");
                String description = rs.getString("DESCRIPTION");
                categList.add(new Categ(id, category, description));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/html/areaRestrita/erro.jsp").forward(request, response);
        }

        // Define o atributo para a lista de administradores
        request.setAttribute("categList", categList);

        // Encaminha para a página JSP de listagem de administradores
        request.getRequestDispatcher("/html/areaRestrita/edenAreaRestritaPrimeiros_categoria.jsp").forward(request, response);
    }
}
