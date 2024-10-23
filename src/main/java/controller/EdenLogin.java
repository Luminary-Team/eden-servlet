package controller;

import java.io.*;

import dao.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet (name = "principal.EdenLogin", value = "/html/edenlogin")
public class EdenLogin extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        AdminDAO admin = new AdminDAO();

//        Pegando o email e a senha do usuario
        String email = request.getParameter("user");
        String senha = request.getParameter("passwd");
        String nomeAdmin = admin.verificarAdmin(email, senha);

        HttpSession session = request.getSession();

        if (nomeAdmin != null){ // Caso o login esteja certo, redireciona para a area de admin
            // Setar valor no atributo que vai mandar para o jsp
            session.setAttribute("nomeAdmin", nomeAdmin);
            // Enviar dados para o jsp
            response.sendRedirect("/html/areaRestrita/edenAreaAdmins.jsp");

        }else{
            // Mensagem de erro para a variavel que receber
            session.setAttribute("erro", "Senha e/ou e-mail incorretos!");
            response.sendRedirect("/html/edenLogin.jsp");
        }
    }


    public void destroy(){
    }
}
