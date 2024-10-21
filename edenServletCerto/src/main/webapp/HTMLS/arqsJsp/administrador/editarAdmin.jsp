<%@ page import="dao.AdminDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Editando adm</title>
    </head>
    <body>
    <h1>Essa pagina é a certa</h1>
    <%
        AdminDAO dao = new AdminDAO();
        int id = Integer.parseInt(request.getParameter("id_admin"));
        String nome=null;
        String email =null;
        String senha=null;
        try {
            ResultSet rs = dao.getAdm(id);
            while (rs.next()) {
                nome = rs.getString("FULL_NAME");
                email = rs.getString("EMAIL");
                senha = rs.getString("PASSWORD");
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            request.setAttribute("errorMessage", "Erro ao carregar os administradores.");
            request.getRequestDispatcher("/HTMLS/areaRestrita/erro.jsp").forward(request, response);
        }
    %>

    <form action="editarAdmin" >
        <input type="number" placeholder="<%=id%>" name="id" readonly>
        <input type="text" placeholder="<%=nome%>" name="nome">
        <input type="text" placeholder="<%=email%>" name="email">
        <input type="text" placeholder="<%=senha%>" name="senha">
        <button>Alterar</button>
    </form>
    </body>
</html>