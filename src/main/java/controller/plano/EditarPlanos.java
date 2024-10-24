package controller.plano;

import dao.PlanosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Planos", value = "/html/areaRestrita/plan")
public class EditarPlanos extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PlanosDAO dao = new PlanosDAO();

    int id_plan = Integer.parseInt(request.getParameter("id_plan"));
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    double preco = Double.parseDouble(request.getParameter("description"));
    int duration_days = Integer.parseInt(request.getParameter("duration_days"));


    if (dao.editarPlan(id_plan, name, description, preco, duration_days)){
        // Se a inserção for bem-sucedida, redireciona para a página de sucesso
        response.sendRedirect("/html/arqsJsp/inserido.jsp");
    } else {
        // Se a inserção falhar, redireciona para a página de erro
        response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
    }
    }
}

