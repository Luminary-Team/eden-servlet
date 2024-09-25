package com.example.edenservlet;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet (name = "EdenLogin", value = "/cadastro-forms")
public class EdenLogin extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String cadastro = "C:\\Users\\User\\Desktop\\TestandoServelet\\Teste com eden\\edenServlet\\src\\main\\java\\com\\example\\edenservlet\\cadastro";

        String username = request.getParameter("nome-for");
        String email = request.getParameter("email-for");
        String senha = request.getParameter("pass-for");

        try{
            FileWriter fileWriter = new FileWriter(cadastro);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print("User: " + username + " E-mail: " + email + " Senha: " + senha);
            printWriter.close();

        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
    }

    public void destroy(){

    }

}
