package controller.ativarPlano;

import dao.AtvPlanoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AtvPlan;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AtvPlano", value = "/jsp/areaRestrita/atvPlan")
public class AtvPlano extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AtvPlanoDAO dao = new AtvPlanoDAO();
        List<AtvPlan> atvPlansList= new ArrayList<>(); // É criado uma lista para mandar para a página JSP

        // O método "getAtvPlanos" serve para dar um SELECT na tabela de Planos Ativos do banco e pega-se o valor das colunas do banco
        // atribuindo valores numa variável.

        try{
            ResultSet rs = dao.getAtvPlanos();
            while (rs.next()){
                int idAtvPlan = rs.getInt("ID_ACTIVATE_PLAN");
                String nameProduct = rs.getString("NAME");
                String nameFull = rs.getString("FULL_NAME");
                String namePlan = rs.getString("PLAN_NAME");
                String onDate = rs.getString("ACTIVATION_DATE");
                String offDate = rs.getString("DEACTIVATION_DATE");
                boolean status = rs.getBoolean("ACTIVE_STATUS");
                atvPlansList.add(new AtvPlan(idAtvPlan, nameProduct, nameFull, namePlan, onDate, offDate, status));
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
            // Caso ocorra um erro, identifico esse erro e mando um atributo com o porquê desse erro para a jsp.
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/jsp/arqsJsp/inseridoErro.jsp").forward(request, response);
        }

        // Manda a lista para a JSP
        request.setAttribute("atvPlansList", atvPlansList);
        // Encaminha o usuário para a JSP
        request.getRequestDispatcher("/jsp/areaRestrita/edenAreaRestritaPrimeiros_ativarPlano.jsp").forward(request, response);
    }
}
