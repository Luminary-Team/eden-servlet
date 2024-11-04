package controller.artigos;

import dao.AdminDAO;
import dao.ArtigosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditarArtigos", value = "/html/areaRestrita/editarArtigos")
public class EditarArtigos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtigosDAO dao = new ArtigosDAO();

         // Pegando valores da JSP
            int id_article = Integer.parseInt(request.getParameter("id_article"));
            String headLine = request.getParameter("headline");
            String news_url = request.getParameter("news_url");
            String source = request.getParameter("source");

            // chamada dos métodos da classe ArtigosDAO para editar essas variáveis no banco de dados
            if (dao.editarArtigo(id_article, headLine, news_url, source)){
                // Se a inserção for bem-sucedida, redireciona para a página de sucesso
                response.sendRedirect("/html/arqsJsp/inserido.jsp");
            } else {
                // Se a inserção falhar, redireciona para a página de erro
                response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
            }
        }
    }

