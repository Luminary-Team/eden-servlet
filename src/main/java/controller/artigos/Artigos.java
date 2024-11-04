package controller.artigos;

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

@WebServlet(name = "Artigos", value = "/jsp/areaRestrita/arts")
public class Artigos  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArtigosDAO dao = new ArtigosDAO();
        List<Artgs> artsList= new ArrayList<>(); // Criado uma lista para passar de parâmetro para a pagina JSP

        // O método "getArtigos" serve para dar um SELECT na tabela de artigos do banco e pega-se o valor das colunas do banco
        // atribuindo valores numa variável.

        try{
            ResultSet rs = dao.getArtigos();
            while (rs.next()){
                int id = rs.getInt("ID_ARTICLE");
                String manchete = rs.getString("HEADLINE");
                String noticiaUrl = rs.getString("NEWS_URL");
                String fonte = rs.getString("SOURCE");
                artsList.add(new Artgs(id, manchete, noticiaUrl, fonte));
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
            // Caso ocorra um erro, identifico esse erro e mando um atributo com o porquê desse erro para a jsp.
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/jsp/areaRestrita/erro.jsp").forward(request, response);
        }

        // Mando a lista para a página JSP.
        request.setAttribute("artsList", artsList);
        // Encaminha para a JSP
        request.getRequestDispatcher("/jsp/areaRestrita/edenAreaRestritaPrimeiros_artigos.jsp").forward(request, response);
    }
}
