package controller.categorias;

import dao.CategoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditarCategorias", value = "/html/areaRestrita/editarCateg")
public class EditarCategorias extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoDAO dao = new CategoDAO();

        // Pegando valores da JSP
        int pk_id = Integer.parseInt(request.getParameter("id_categ"));
        String category= request.getParameter("category");
        String description = request.getParameter("description");

        // Chamando método da classe DAO para editar dados do banco
        if (dao.editarCategory(pk_id ,category, description)){
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }
    }
}

