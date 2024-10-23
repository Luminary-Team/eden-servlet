package controller.artigos;

import dao.AdminDAO;
import dao.ArtigosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Artgs;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Artigos", value = "/html/areaRestrita/addArtigos")
public class AdicionarArtigos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtigosDAO dao = new ArtigosDAO();

        // Pegando as informações do Artigo
        String headLine = request.getParameter("headline");
        String news_url = request.getParameter("news_url");
        String source = request.getParameter("sorce");


        // AdminDAO para adicionar o novo admin
        if (dao.adicionarArtigo(headLine, news_url, source)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }



    }
}
