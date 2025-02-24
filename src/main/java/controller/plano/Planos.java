package controller.plano;

import dao.AdminDAO;
import dao.PlanosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Plan;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Planos", value = "/jsp/areaRestrita/plan")
public class Planos extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PlanosDAO dao = new PlanosDAO();
    List<Plan> planList = new ArrayList<>(); // Lista para mandar para a JSP

    // O método "getPlanos" serve para dar um SELECT na tabela de Planos do banco e pega-se o valor das colunas do banco
    // atribuindo valores numa variável.

    try {
        ResultSet rs = dao.getPlanos();
        while (rs.next()) {
            int id = rs.getInt("ID_PLAN");
            String nome = rs.getString("NAME");
            String descricao = rs.getString("DESCRIPTION");
            double preco = rs.getDouble("PRICE");
            int dias = rs.getInt("DURATION_DAYS");
            planList.add(new Plan(id, nome, descricao, preco, dias));
        }
    } catch (SQLException sqe) {
        sqe.printStackTrace();
        // Caso ocorra um erro, identifico esse erro e mando um atributo com o porquê desse erro para a jsp.
        request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
        request.getRequestDispatcher("/jsp/areaRestrita/erro.jsp").forward(request, response);
    }

    // Define o atributo para a lista de administradores
    request.setAttribute("planList", planList);

    // Encaminha para a página JSP de listagem de administradores
    request.getRequestDispatcher("/jsp/areaRestrita/edenAreaRestritaPrimeiros_plano.jsp").forward(request, response);
    }
}

