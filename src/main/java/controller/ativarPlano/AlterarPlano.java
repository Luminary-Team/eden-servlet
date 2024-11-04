package controller.ativarPlano;

import dao.AtvPlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AlterarPlano", value = "/html/areaRestrita/alterarPlan")
public class AlterarPlano extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AtvPlanoDAO dao = new AtvPlanoDAO();

//        Pegando valores da JSP.
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

//        Chamando métodos da classe DAO para editar dados no banco
        if (dao.editarAtvPlan(id, status)){
//            Caso dê certo, encaminha para a página de inserido
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
        }else{
//            Caso dê erro, encaminha para a página de inserção incorreta
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }
    }
}

