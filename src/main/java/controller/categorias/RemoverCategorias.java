package controller.categorias;

import dao.CategoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RemoverCategorias", value = "/jsp/areaRestrita/rmvCateg")
public class RemoverCategorias extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoDAO dao = new CategoDAO();

//        Pegando valores da JSP
        int pk_id = Integer.parseInt(request.getParameter("id_categ"));

        // CategoDAO para remover uma categoria
        if (dao.removeCategory(pk_id)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/jsp/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/jsp/arqsJsp/inseridoErro.jsp");
        }
    }
}

