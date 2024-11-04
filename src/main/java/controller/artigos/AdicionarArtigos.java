package controller.artigos;

import dao.ArtigosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdicionarArtigos", value = "/html/areaRestrita/addArtigo")
public class AdicionarArtigos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtigosDAO dao = new ArtigosDAO();

        // Pegando as informações do Artigo
        String headLine = request.getParameter("headline");
        String news_url = request.getParameter("news_url");
        String source = request.getParameter("source");

        // Chamando método da classe DAO para adicionar novos dados no banco
        if (dao.adicionarArtigo(headLine, news_url, source)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }



    }
}
