package controller.artigos;

import dao.AdminDAO;
import dao.ArtigosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Artigos", value = "/html/areaRestrita/editarArtigos")
public class EditarArtigos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtigosDAO dao = new ArtigosDAO();

         // Pegando o email e a senha do usuário
            int id_article = Integer.parseInt(request.getParameter("id-article"));
            String headLine = request.getParameter("headLine");
            String news_url = request.getParameter("news_url");
            String source = request.getParameter("source");


            if (dao.editarArtigo(id_article, headLine, news_url, source)){
                // Se a inserção for bem-sucedida, redireciona para a página de sucesso
                response.sendRedirect("/html/arqsJsp/inserido.jsp");
            } else {
                // Se a inserção falhar, redireciona para a página de erro
                response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
            }
        }
    }
