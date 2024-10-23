package controller.artigos;

import dao.ArtigosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Artigos", value = "/html/areaRestrita/editarArtigos")
public class RemoverArtigos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtigosDAO dao = new ArtigosDAO();

        int id_article = Integer.parseInt(request.getParameter("id-article"));

        // AdminDAO para remover um admin
        if (dao.removeArtigo(id_article)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
            System.out.println("Removido com sucesso");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }
    }
}
