package controller.plano;

import dao.PlanosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditarPlanos", value = "/jsp/areaRestrita/editarPlano")
public class EditarPlanos extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PlanosDAO dao = new PlanosDAO();

//    Pegando valores da JSP.

    int id_plan = Integer.parseInt(request.getParameter("id_plan"));
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    double preco = Double.parseDouble(request.getParameter("price"));
    int duration_days = Integer.parseInt(request.getParameter("duration"));


//    Chamando método da classe DAO para editar dados no banco
    if (dao.editarPlan(id_plan, name, description, preco, duration_days)){
        // Se a inserção for bem-sucedida, redireciona para a página de sucesso
        response.sendRedirect("/jsp/arqsJsp/inserido.jsp");
    } else {
        // Se a inserção falhar, redireciona para a página de erro
        response.sendRedirect("/jsp/arqsJsp/inseridoErro.jsp");
    }
    }
}

