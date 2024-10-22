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

@WebServlet(name = "AtvPlano", value = "/HTMLS/areaRestrita/atvPlan")
public class AtvPlano extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AtvPlanoDAO dao = new AtvPlanoDAO();
        List<AtvPlan> atvPlansList= new ArrayList<>();

        try{
            ResultSet rs = dao.getAtvPlanos();
            while (rs.next()){
                int idAtvPlan = rs.getInt("ID_ACTIVATE_PLAN");
                int idProd = rs.getInt("PRODUCT_ID");
                int idUser = rs.getInt("USER_ID");
                int idPlan = rs.getInt("PLAN_ID");
                String onDate = rs.getString("ACTIVATION_DATE");
                String offDate = rs.getString("DESACTIVATION_DATE");
                boolean status = rs.getBoolean("ACTIVE_STATUS");
                atvPlansList.add(new AtvPlan(idAtvPlan, idProd, idUser, idPlan, onDate, offDate, status));
            }
        }catch (SQLException sqe){
            sqe.printStackTrace();
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/HTMLS/areaRestrita/erro.jsp").forward(request, response);
        }

        request.setAttribute("atvPlansList", atvPlansList);
        request.getRequestDispatcher("/HTMLS/areaRestrita/edenAreaRestritaPrimeiros_ativarPlano.jsp").forward(request, response);
    }
}
