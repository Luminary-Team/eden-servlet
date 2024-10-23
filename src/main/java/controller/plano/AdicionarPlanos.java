package controller.plano;

import dao.PlanosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Plan;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Planos", value = "/html/areaRestrita/plan")
public class AdicionarPlanos extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PlanosDAO dao = new PlanosDAO();

    // Pegando as informações da Planos

    String name= request.getParameter("name");
    String description = request.getParameter("description");
    Double price= Double.parseDouble(request.getParameter("price"));
    int duration_days = Integer.parseInt(request.getParameter("duration_days"));

    // AdminDAO para adicionar o novo Plano
    if (dao.adicionarPlano(name, description, price, duration_days)) {
        // Se a inserção for bem-sucedida, redireciona para a página de sucesso
        response.sendRedirect("/html/arqsJsp/inserido.jsp");
    } else {
        // Se a inserção falhar, redireciona para a página de erro
        response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
    }
    }
}

