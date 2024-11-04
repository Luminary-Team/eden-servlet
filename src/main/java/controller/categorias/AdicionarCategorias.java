package controller.categorias;

import dao.CategoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categ;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdicionarCategorias", value = "/jsp/areaRestrita/addCateg")
public class AdicionarCategorias extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoDAO dao = new CategoDAO();

        // Pegando as informações da Categoria

        String category= request.getParameter("category");
        String description = request.getParameter("description");


        // CategoDAO para adicionar o nova categoria
        if (dao.adicionarCategoria(category, description)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/jsp/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/jsp/arqsJsp/inseridoErro.jsp");
        }



    }
}
