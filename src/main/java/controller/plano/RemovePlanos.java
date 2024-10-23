package controller.plano;

import dao.PlanosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Planos", value = "/html/areaRestrita/plan")
public class RemovePlanos extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanosDAO dao = new PlanosDAO();

        int id_plan = Integer.parseInt(request.getParameter("id-plan"));

        // AdminDAO para remover um admin
        if (dao.removePlan(id_plan)) {
            // Se a inserção for bem-sucedida, redireciona para a página de sucesso
            response.sendRedirect("/html/arqsJsp/inserido.jsp");
            System.out.println("Removido com sucesso");
        } else {
            // Se a inserção falhar, redireciona para a página de erro
            response.sendRedirect("/html/arqsJsp/inseridoErro.jsp");
        }
    }
}

